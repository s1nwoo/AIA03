package com.wifi.comment.dao;

import java.util.List;
import java.util.Map;

import com.wifi.comment.model.Comment;
import com.wifi.comment.model.Criteria;

public interface CommentDao {


	// 댓글 리스트 <List>
	List<Comment> listComment();
	
	// 댓글 등록 insert 
	int insertComment(Comment comment);
	
	// 댓글 수정 update
	int editComment(Comment comment);
	
	// 댓글 삭제 delete
	int deleteComment(int cIdx);
	
	// 댓글 선택
	Comment selectCommentByCidx(int cIdx);

	
}
