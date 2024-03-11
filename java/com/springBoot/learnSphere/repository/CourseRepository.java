package com.springBoot.learnSphere.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.learnSphere.entity.Course;



public interface CourseRepository extends JpaRepository<Course, Integer>{

}