package com.wifi.comment.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CommentEditRequest {

	private int cidx;
	private String content;
	private int state;
	private Timestamp regdate;
	private Timestamp updatedate;
	
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


	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}



	public Comment toComment() {
			return new Comment(cidx, regdate, updatedate, content, state, 0, 0);
	}


	@Override
	public String toString() {
		return "CommentEditRequest [cidx=" + cidx + ", content=" + content + ", state=" + state + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + "]";
	}







	
	
	
	
	
}
