package com.wifi.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;

@Service
public class CommentViewService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public Comment getComment(int cIdx) {
		
		dao = template.getMapper(CommentDao.class);
		
		return dao.selectCommentByCidx(cIdx);
		
	}
	
	
	
}
