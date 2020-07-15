package member.model;

import java.util.List;

public class MemberListView {
	
	private int memberTotalCount;
	private int currentPage;
	private List<Member> memberList;
	private int countPerPage;
	private int startRow;
	private int pageTotalCount;
	
	public MemberListView(int memberTotalCount, int currentPage, List<Member> memberList, int countPerPage,
			int startRow) {
		this.memberTotalCount = memberTotalCount;
		this.currentPage = currentPage;
		this.memberList = memberList;
		this.countPerPage = countPerPage;
		this.startRow = startRow;
	}
	private void calTotalPageCount() {
		if(memberTotalCount ==0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = memberTotalCount/countPerPage;
			if(memberTotalCount%countPerPage>0) {
				pageTotalCount++;
			}
		}
	}
	public int getMemberTotalCount() {
		return memberTotalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public int getStartRow() {
		return startRow;
	}
	
	
	
}