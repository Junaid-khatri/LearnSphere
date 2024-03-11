package com.springBoot.learnSphere.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.learnSphere.entity.Lesson;



public interface LessonRepository extends JpaRepository<Lesson, Integer>{

}