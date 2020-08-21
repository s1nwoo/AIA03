package com.wifi.comment.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentRegRequest {

	private String content;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	// CommentRegRequest -> Comment
	public Comment toComment() {
		return new Comment(content, regdate, updatedate);
	//	return new Comment(content, regdate);
	}

	@Override
	public String toString() {
		return "CommentRegRequest [content=" + content + ", regdate=" + regdate + ", updatedate=" + updatedate + "]";
	}


	



	
	
	
}
