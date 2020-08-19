package com.wifi.comment.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentEditRequest;

@Service
public class CommentEditService {

	private CommentDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int editComment(
			CommentEditRequest editRequest,
			HttpServletRequest request
			) {
		
		dao= template.getMapper(CommentDao.class);
		
		int result = 0;
				
		Comment comment = editRequest.toComment();
		
		result = dao.editComment(comment);
		
		return result;
		
	}
	
	
	
}
