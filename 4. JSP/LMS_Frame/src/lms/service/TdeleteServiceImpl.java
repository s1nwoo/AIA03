package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.TeacherDao;

public class TdeleteServiceImpl implements Service {

	TeacherDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		
		String msg = "";
		
		
		try {
			int tIdx = Integer.parseInt(request.getParameter("tIdx"));
			
			conn = ConnectionProvider.getConnection();
			dao = TeacherDao.getInstance();
			
			int resultCnt = dao.deleteTeacher(conn, tIdx);

			switch(resultCnt) {
			case 0:
				msg="요청하신 데이터가 존재하지 않습니다.";
			case 1:
				msg="정상적으로 삭제되었습니다.";
			}
			
		} catch (SQLException e) {
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

		request.setAttribute("msg", msg);

		return "/WEB-INF/views/admin/tList.jsp";
	}

}