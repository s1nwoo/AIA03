package com.wifi.comment.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {

	private int idx;
	private Date regdate;
	private String content;
	private int state;

	// CommentRegRequest -> Comment
	public Comment(String content) {
		this(0, null, content, 0);
	}
	
	public Comment() {
	}

	
	public Comment(int idx, Date regdate, String content, int state) {
		this.idx = idx;
		this.regdate = regdate;
		this.content = content;
		this.state = state;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getState() {
		return state;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setState(int state) {
		this.state = state;
	}
	
	// java.sql.Date -> java.util.Date
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public java.util.Date getToDate() {// ${member.toDate}
		return new java.util.Date(regdate.getTime());
	}

	@Override
	public String toString() {
		return "Comment [idx=" + idx + ", regdate=" + regdate + ", content=" + content + ", state=" + state + "]";
	}
	
		
	
}
