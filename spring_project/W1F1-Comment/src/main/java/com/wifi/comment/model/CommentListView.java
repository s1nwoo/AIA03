package com.wifi.comment.model;

import java.util.List;

public class CommentListView {

	// 댓글 목록
	private List<Comment> commentList;
	// 댓글 총 갯수
	private int commentTotalCount;
	// 페이지 총 갯수
	private int pageTotalCount;
	// 현재 페이지 번호
	private int currentPageNumber;
	// 한 페이지 당 노출한 게시물의 개수
	private int commentCountPerpage;
	// 첫 번째 행의 index
	private int startRow;
	
	public CommentListView(List<Comment> commentList, int commentTotalCount, int pageTotalCount, int currentPageNumber,
			int commentCountPerpage, int startRow) {
		this.commentList = commentList;
		this.commentTotalCount = commentTotalCount;
		this.pageTotalCount = pageTotalCount;
		this.currentPageNumber = currentPageNumber;
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

	public List<Comment> getCommentList() {
		return commentList;
	}

	public int getCommentTotalCount() {
		return commentTotalCount;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public int getCommentCountPerpage() {
		return commentCountPerpage;
	}

	public int getStartRow() {
		return startRow;
	}

	@Override
	public String toString() {
		return "CommentListView [commentList=" + commentList + ", commentTotalCount=" + commentTotalCount
				+ ", pageTotalCount=" + pageTotalCount + ", currentPageNumber=" + currentPageNumber
				+ ", commentCountPerpage=" + commentCountPerpage + ", startRow=" + startRow + "]";
	}

	
	
	
}
