package com.springBoot.learnSphere.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.learnSphere.entity.Comments;



public interface CommentRepository extends JpaRepository<Comments,Integer>{

}