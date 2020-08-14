package com.wifi.comment.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentRegRequest;

@Service
public class CommentInsertService {

	private CommentDao dao;
	
	@Autowired
	SqlSessionTemplate template;
	
	public int regComment(
			CommentRegRequest regRequest,
			HttpServletRequest request
			) {
		
		Comment comment = regRequest.toComment();
		
		dao = template.getMapper(CommentDao.class);
		
		int result = 0;
		
		result = dao.insertComment(comment);
		
		return result;
	}
	
}
