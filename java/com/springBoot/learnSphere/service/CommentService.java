package com.springBoot.learnSphere.service;


import java.util.List;

import com.springBoot.learnSphere.entity.Comments;



public interface CommentService {
	List<Comments> commentList();
	String addComment(Comments comment);
}