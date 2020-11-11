package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.TeacherDao;
import lms.model.Teacher;

public class TsearchServiceImpl implements Service {

	TeacherDao dao;
	Teacher teacher;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		Connection conn = null;
		int tIdx = Integer.parseInt(request.getParameter("search"));

		try {
			conn = ConnectionProvider.getConnection();
			dao = TeacherDao.getInstance();
			
			teacher = dao.selectTeacherByIdx(conn, tIdx);


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

		request.setAttribute("teacher", teacher);

		return "/WEB-INF/views/admin/tList.jsp";
	}

}