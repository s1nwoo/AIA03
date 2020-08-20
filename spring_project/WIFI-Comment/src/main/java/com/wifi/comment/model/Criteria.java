package com.wifi.comment.model;

public class Criteria {

	// 현재 페이지 번호
	private int page;
	// 한 페이지당 보여줄 댓글 갯수
	private int perPageNum;
	
	// 특정 페이지의 댓글 시작 번호, 댓글 시작 행 번호
	public int getPageStart() {
		return(this.page-1)*perPageNum;
	}
	
	public Criteria() {
		// 현재 페이지 1번
		this.page = 1;
		// 댓글 10개 씩
		this.perPageNum = 10;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;	
		} else {
			this.page = page;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int pageCount) {
		int cnt = this.perPageNum;
		if(pageCount != cnt) {
			this.perPageNum = cnt;
		} else {
			this.perPageNum = pageCount;
		}
	}
	
	
	
}
