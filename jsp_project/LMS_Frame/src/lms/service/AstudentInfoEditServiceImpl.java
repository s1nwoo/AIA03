package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.dao.TeacherDao;
import lms.model.Student;
import lms.model.Teacher;

public class AstudentInfoEditServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	Student student;
	StudentDao Dao;

	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		// form에서 입력한 전화번호와 이메일 가져오기

		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String major = request.getParameter("major");
		int grade = Integer.parseInt(request.getParameter("grade"));
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");

		// 변수 초기화
		Connection conn = null;
		int result = 0;

		try {
			conn = ConnectionProvider.getConnection();
			Dao = StudentDao.getInstance();

			sIdx = student.getsIdx();
			result = Dao.editStudentByAdmin(conn, sIdx, pw, name, major, grade, tel, email);

			request.setAttribute("chgSidx", sIdx);
			request.setAttribute("chgPw", pw);
			request.setAttribute("chgName", name);
			request.setAttribute("chgMajor", major);
			request.setAttribute("chgGrade", grade);
			request.setAttribute("chgTel", tel);
			request.setAttribute("chgEmail", email);


		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "/WEB-INF/views/admin/sList.jsp";
	}

}
