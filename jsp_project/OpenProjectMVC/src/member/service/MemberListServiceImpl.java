package member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.ConnectionProvider;
import member.dao.MemberDao;
import member.model.Member;
import member.model.MemberListView;
import service.Service;

public class MemberListServiceImpl implements Service {
	
	MemberDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		Connection conn = null;
		MemberListView memberListView = null;
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			List<Member> memberList = null;
			// 한 페이지 당 노출할 가입자 수
			final int COUNT_PER_PAGE = 3;
			
			// 전체 가입자수
			int memberTotalCount = dao.selectTotalCount(conn);
			// 시작  index
			int startRow = 0;
			// 현재 페이지 수
			int currentPage = 1;
			String pageNum = request.getParameter("page");
			if(pageNum != null){
				currentPage = Integer.parseInt(pageNum);
			}
			
			if(memberTotalCount>0) {
				startRow = (currentPage-1)*COUNT_PER_PAGE;
				System.out.println(startRow);
				memberList = dao.selectList(conn, startRow);
			} else {
				currentPage = 0;
				memberList = Collections.emptyList();
			}
			
			memberListView = new MemberListView(
												memberTotalCount,
												currentPage,
												memberList,
												COUNT_PER_PAGE,
												startRow);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("listView", memberListView);
		
		return "/WEB-INF/views/member/memberList.jsp";
	}
}