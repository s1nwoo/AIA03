package com.wifi.comment.model;

public class CommentEditRequest {

	private int idx;
	private String content;
	private int state;
	
	public int getIdx() {
		return idx;
	}



	public void setIdx(int idx) {
		this.idx = idx;
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

		return new Comment(idx, null, content, state);
		
	}

	@Override
	public String toString() {
		return "CommentEditRequest [idx=" + idx + ", content=" + content + ", state=" + state + "]";
	}
	
	
	
	
}
