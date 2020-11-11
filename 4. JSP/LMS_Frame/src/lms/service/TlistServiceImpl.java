package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.TeacherDao;
import lms.model.Teacher;
import lms.model.TeacherListView;

public class TlistServiceImpl implements Service {

	TeacherDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		TeacherListView tListView = null;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = TeacherDao.getInstance();

			
			List<Teacher> teacherList = null;
			
			teacherList = dao.teacherList(conn);
			
			tListView = new TeacherListView(teacherList);


		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		}

		request.setAttribute("tListView", tListView);

		return "/WEB-INF/views/admin/tList.jsp";
	}

}