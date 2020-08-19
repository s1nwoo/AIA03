package com.wifi.comment.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentRegRequest {

	private String content;
	private Date regdate;
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegdate() {
		return regdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

	// CommentRegRequest -> Comment
	public Comment toComment() {
		return new Comment(content, regdate);
	}


	@Override
	public String toString() {
		return "CommentRegRequest [content=" + content + ", regdate=" + regdate + "]";
	}



	
	
	
}
