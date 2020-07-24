package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.dao.TempletDao;
import lms.model.Student;
import lms.model.TempletModel;

public class SdeleteServiceImpl implements Service {

	// Service 클래스 이용에 대한 예제 클래스입니다.
	StudentDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		int resultCnt = 0;
		
		Student student = null;
		
		Connection conn = null;
		
		try {

			conn = ConnectionProvider.getConnection();
			dao = StudentDao.getInstance();
			
			resultCnt = dao.deleteStudent(conn, student);

			request.setAttribute("resultCnt", resultCnt);

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
		

		return "/WEB-INF/views/admin/tList.jsp";
	}

}
