package com.wifi.comment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;

@Service
public class CommentTotalService {

private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int countBoardListTotal() {
		
		dao = template.getMapper(CommentDao.class);
		return dao.countBoardList();
	}
	
}
