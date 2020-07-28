package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.model.Student;


public class SsearchServiceImpl implements Service {

	StudentDao dao;
	Student student;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		int sIdx = Integer.parseInt(request.getParameter("search"));	// name = "search" 라는 input box

		try {
			conn = ConnectionProvider.getConnection();
			dao = StudentDao.getInstance();
			
			student = dao.selectStudentByIdx(conn, sIdx);


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

		request.setAttribute("student", student);

		return "/WEB-INF/views/admin/sList.jsp";
	}

}