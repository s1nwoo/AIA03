package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.model.Student;

public class SaddServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	StudentDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		int resultCnt = 0;
		Connection conn = null;
		Student student = null;
		
		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String major = request.getParameter("major");
		int grade = Integer.parseInt(request.getParameter("grade"));
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = StudentDao.getInstance();
			
			student = new Student();
			student.setsIdx(sIdx);
			student.setPw(pw);
			student.setName(name);
			student.setTel(tel);
			student.setEmail(email);
			student.setMajor(major);
			student.setGrade(grade);
			
			
			resultCnt = dao.insertStudent(conn, student);
			
			request.setAttribute("student", student);
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
		
		return "/WEB-INF/views/admin/sList.jsp";
	}

}
