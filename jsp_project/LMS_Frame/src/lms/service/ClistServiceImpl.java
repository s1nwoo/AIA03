package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.dao.TeacherDao;
import lms.model.Course;
import lms.model.CourseListView;
import lms.model.Teacher;
import lms.model.TeacherListView;

public class ClistServiceImpl implements Service {

	CourseDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		CourseListView cListView = null;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = CourseDao.getInstance();

			
			List<Course> courseList = null;
			
			courseList = dao.courseList(conn);
			cListView = new CourseListView(courseList);


		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		}

		request.setAttribute("cListView", cListView);

		return "/WEB-INF/views/admin/cList.jsp";
	}

}