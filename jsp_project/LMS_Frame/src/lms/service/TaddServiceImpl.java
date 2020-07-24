package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.StudentDao;
import lms.dao.TeacherDao;
import lms.model.Student;
import lms.model.Teacher;

public class TaddServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	TeacherDao dao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		int resultCnt = 0;
		Connection conn = null;
		Teacher teacher = null;
		
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String major = request.getParameter("major");
		String job = request.getParameter("job");
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = TeacherDao.getInstance();
			
			teacher = new Teacher();
			teacher.settIdx(tIdx);
			teacher.setPw(pw);
			teacher.setName(name);
			teacher.setTel(tel);
			teacher.setEmail(email);
			teacher.setMajor(major);
			teacher.setJob(job);
			
			
			resultCnt = dao.insertTeacher(conn, teacher);
			
			request.setAttribute("teacher", teacher);
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
