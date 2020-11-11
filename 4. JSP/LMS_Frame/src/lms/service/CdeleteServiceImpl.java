package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Student;

public class CdeleteServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	CourseDao dao;
	Student student;
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		String type = (String) session.getAttribute("loginType");
		
		int resultCnt = 0;		
		Connection conn = null;
		String path = null;
		int cIdx = Integer.parseInt(request.getParameter("cIdx"));
		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = CourseDao.getInstance();
			
			if(type.equals("tLogin")){
				resultCnt = dao.deleteCourse(conn, cIdx);
				path = "/WEB-INF/views/teacher/tMypage.jsp";
			} else {
				student = (Student)session.getAttribute("info");
				resultCnt = dao.deleteMyCourse(conn, cIdx, sIdx);
				path = "/WEB-INF/views/student/sClassAddForm.jsp";
			}
			
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
		
		return path;
	}

}
