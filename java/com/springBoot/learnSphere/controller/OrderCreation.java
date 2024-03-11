package com.springBoot.learnSphere.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.springBoot.learnSphere.entity.Course;
import com.springBoot.learnSphere.entity.Users;
import com.springBoot.learnSphere.service.TrainerService;
import com.springBoot.learnSphere.service.UserService;


@Controller
public class OrderCreation {
	
	@Autowired
	UserService us;
	
	@Autowired
	TrainerService tService;
	
	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("amount") int amount,
							@RequestParam("email") String email,
							@RequestParam("courseId") int courseId) {
//		System.out.println(amount+email+courseId);
		
		Order order=null;
		try {
			RazorpayClient razorpay=new RazorpayClient("rzp_test_NGW6dNC6kxdf8l", "nReds5vKjqzuZObtXm5RhpgF");
			
			JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");

			  order = razorpay.orders.create(orderRequest);
			  
			  
			  attachCourse(email, courseId);
			  
		
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return order.toString();
		}
	}
	public void attachCourse(String email, int courseId) {
		
		
		Course course=tService.getCourse(courseId);
		Users user=us.getUser(email);
		
		user.getCourses().add(course);
		course.getUserList().add(user);
	
		us.updateUser(user);
		tService.saveCourse(course);
	}
}