package com.wifi.comment.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wifi.comment.dao.CommentDao;
import com.wifi.comment.model.Comment;
import com.wifi.comment.model.CommentPaging;

@Service
public class CommentListService {

	private CommentDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public List<Comment> getCommentList(
			){
		
		dao = template.getMapper(CommentDao.class);
		
		return dao.listComment();
		
	}
	
}
