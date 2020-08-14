package com.wifi.comment.model;

public class CommentRegRequest {

	private String content;
	
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	// CommentRegRequest -> Comment
	public Comment toComment() {
		return new Comment(content);
	}


	@Override
	public String toString() {
		return "CommentRegRequest [content=" + content + "]";
	}
	
	
	
}
