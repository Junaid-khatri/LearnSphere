package com.springBoot.learnSphere.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.learnSphere.entity.Comments;
import com.springBoot.learnSphere.repository.CommentRepository;


@Service
public class CommentSeviceImplementation implements CommentService {

	@Autowired
	CommentRepository commentRepo;
	@Override
	public List<Comments> commentList() {
		return commentRepo.findAll();
	}
	@Override
	public String addComment(Comments comment) {
		commentRepo.save(comment);
		return "comment added";
	}

}