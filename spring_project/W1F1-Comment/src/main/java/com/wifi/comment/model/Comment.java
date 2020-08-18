package com.wifi.comment.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Comment {

	// 댓글 번호
	private int cidx;
	// 댓글 작성 시간
	private Date regdate;
	// 댓글 내용
	private String content;
	// 댓글 상태
	private int state;
	// 작성자 번호
	private int midx;
	// 글 번호
	private int iidx;

	// CommentRegRequest -> Comment
	public Comment(String content) {
		this(0, null, content, 0, 0, 0);
	}
	
	public Comment() {
	}

	
	public Comment(int cidx, Date regdate, String content, int state, int midx, int iidx) {
		this.cidx = cidx;
		this.regdate = regdate;
		this.content = content;
		this.state = state;
		this.midx = midx;
		this.iidx = iidx;
	}

	
	public int getCidx() {
		return cidx;
	}

	public void setCidx(int cidx) {
		this.cidx = cidx;
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

	public void setState(int state) {
		this.state = state;
	}

	public int getMidx() {
		return midx;
	}

	public void setMidx(int midx) {
		this.midx = midx;
	}

	public int getIidx() {
		return iidx;
	}

	public void setIidx(int iidx) {
		this.iidx = iidx;
	}

	public Date getRegdate() {
		return regdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	//java.sql.Date -> java.util.Date
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul") 
	 public java.util.Date getToDate() {// ${member.toDate} return new
		 return new java.util.Date(regdate.getTime()); }

	@Override
	public String toString() {
		return "Comment [cidx=" + cidx + ", regdate=" + regdate + ", content=" + content + ", state=" + state
				+ ", midx=" + midx + ", iidx=" + iidx + "]";
	}
	 


	
		
	
}
