package com.wifi.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentRegRequest;
import com.wifi.comment.service.CommentInsertService;
import com.wifi.comment.service.CommentListService;

@RestController
@RequestMapping("/comment") 
public class CommentController {

	@Autowired
	private CommentInsertService commentInsertService;
	
	@Autowired
	private CommentListService commentListService;
	
	// 댓글 리스트 : Json 으로 응답
	@GetMapping // GET
	public List<Comment> getCommentList(){
		
		return commentListService.getCommentList();
	}
	
	// 댓글 등록
	@PostMapping // POST 
	public int insert(
			CommentRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		
		return commentInsertService.regComment(regRequest, request);
	}
	
}


