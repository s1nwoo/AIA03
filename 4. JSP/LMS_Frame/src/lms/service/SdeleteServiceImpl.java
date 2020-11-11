package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.model.Student;

public class SdeleteServiceImpl implements Service {

	// Service 클래스 이용에 대한 예제 클래스입니다.
	StudentDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		String msg = "";
		
		Connection conn = null;
		
		try {

			int sIdx = Integer.parseInt(request.getParameter("sIdx"));
			
			conn = ConnectionProvider.getConnection();
			dao = StudentDao.getInstance();
			
			int resultCnt = dao.deleteStudent(conn, sIdx);

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

		return "/WEB-INF/views/admin/sList.jsp";
	}

}
