package com.wifi.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;

@Service
public class CommentDeleteService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteCommnet(int cidx) {
		
		dao = template.getMapper(CommentDao.class);
		
		return dao.deleteComment(cidx);
		
	}
	
	
	
}
