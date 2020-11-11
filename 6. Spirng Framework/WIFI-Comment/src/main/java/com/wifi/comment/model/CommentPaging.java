package com.wifi.comment.model;

import java.util.List;

public class CommentPaging {

	// 댓글 총 개수
	private int commentTotalCount;
	// 페이지 번호
	private int currentPageNumber;
	// 댓글 리스트
	private List<Comment> commentList;
	// 페이지 총 갯수
	private int pageTotalCount;
	// 댓글 페이지 갯수
	private int commentCountPerpage;
	private int startRow;

	
	public CommentPaging(int commentTotalCount, int currentPageNumber, List<Comment> commentList, int pageTotalCount,
			int commentCountPerpage, int startRow) {
		this.commentTotalCount = commentTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.commentList = commentList;
		this.commentCountPerpage = commentCountPerpage;
		this.startRow = startRow;
		calTotalCount();
	}

	private void calTotalCount() {
		if(commentTotalCount==0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = commentTotalCount/commentCountPerpage;
			System.out.println(commentTotalCount%commentCountPerpage);
			if(commentTotalCount%commentCountPerpage > 0) {
				pageTotalCount ++;
			}
			System.out.println(pageTotalCount);
		}
	}

	public int getCommentTotalCount() {
		return commentTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getCommentCountPerpage() {
		return commentCountPerpage;
	}

	public int getStartRow() {
		return startRow;
	}

	@Override
	public String toString() {
		return "CommentPaging [commentTotalCount=" + commentTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", commentList=" + commentList + ", pageTotalCount=" + pageTotalCount + ", commentCountPerpage="
				+ commentCountPerpage + ", startRow=" + startRow + "]";
	}

	
}