package com.wifi.comment.model;

public class CommentEditRequest {

	private int cidx;
	private String content;
	private int state;
	
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



	public Comment toComment() {

		return new Comment(cidx, null, content, state, 0, 0);
	}

	@Override
	public String toString() {
		return "CommentEditRequest [cidx=" + cidx + ", content=" + content + ", state=" + state + "]";
	}
	
	
	
	
}
