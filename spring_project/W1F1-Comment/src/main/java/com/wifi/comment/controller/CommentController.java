package com.wifi.comment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentEditRequest;
import com.wifi.comment.model.CommentRegRequest;
import com.wifi.comment.service.CommentDeleteService;
import com.wifi.comment.service.CommentEditService;
import com.wifi.comment.service.CommentInsertService;
import com.wifi.comment.service.CommentListService;
import com.wifi.comment.service.CommentViewService;

@RestController
@RequestMapping("/comment")
@ResponseBody
public class CommentController {

	// 댓글 등록
	@Autowired
	private CommentInsertService commentInsertService;
	
	// 댓글 목록
	@Autowired
	private CommentListService commentListService;
	
	// 댓글 수정
	@Autowired
	private CommentEditService commentEditService;
	
	// 댓글 선택
	@Autowired
	private CommentViewService commentViewService;
	
	// 댓글 삭제
	@Autowired
	private CommentDeleteService commentDeleteService;

	@RequestMapping(value="")
	
	
	// 댓글 등록
	@PostMapping // POST 
	public int insert(
			CommentRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		
		return commentInsertService.regComment(regRequest, request);
	}
	
	// 댓글 목록 : Json 으로 응답
	@GetMapping // GET
	public List<Comment> getCommentList(){
		
		return commentListService.getCommentList();	
	}
	
	// 댓글 수정
	@PostMapping("/{idx}") // PUT
	public int edit(
			@PathVariable("idx") int idx,
			CommentEditRequest editRequest,
			HttpServletRequest request
			) {
		
		editRequest.setIdx(idx);
		
		return commentEditService.editComment(editRequest, request);
		
	}
	
	// 댓글 선택
	@GetMapping("/{idx}")
	public Comment getComment(
			@PathVariable("idx") int idx
			) {
		return commentViewService.getComment(idx);
	}
	
	// 댓글 삭제
	@DeleteMapping("/{idx}")
	public int delete(
			@PathVariable("idx") int idx
			) {
		return commentDeleteService.deleteCommnet(idx);
	}
	

	
	
}


