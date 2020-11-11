package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.model.Student;
import lms.model.StudentListView;

public class SlistServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!

	StudentDao dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		StudentListView sListView = null;

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			dao = StudentDao.getInstance();

			
			List<Student> studentList = null;
			
			studentList = dao.studentList(conn);
			
			sListView = new StudentListView(studentList);


		} catch (SQLException e) {
			System.out.println("SQL 오류 발생");
			e.printStackTrace();
		}

		request.setAttribute("sListView", sListView);

		return "/WEB-INF/views/admin/sList.jsp";
	}

}
