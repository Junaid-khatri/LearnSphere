package com.springBoot.learnSphere.service;

import java.util.List;

import com.springBoot.learnSphere.entity.Course;
import com.springBoot.learnSphere.entity.Lesson;



public interface TrainerService {
	public String addCourse(Course course);
	
	public String saveCourse(Course course);
	
	public String addLesson(Lesson lesson);
	
	public Course getCourse(int courseId);
	
	public List<Course> courseList();
}