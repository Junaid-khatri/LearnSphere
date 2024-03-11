package com.springBoot.learnSphere.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.learnSphere.entity.Lesson;
import com.springBoot.learnSphere.repository.LessonRepository;
import com.springBoot.learnSphere.repository.UserRepository;



@Service
public class StudentServicesImplementation implements StudentServices{
	@Autowired
	UserRepository ur;
	@Autowired
	LessonRepository lessonRepo;
	@Override
	public Lesson getLesson(int lessonId) {
		
		return lessonRepo.findById(lessonId).get();
		
	}
	
	

}
