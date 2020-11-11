package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Student;

public class SclassDelServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	CourseDao cDao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		Student student = null;
		Connection conn = null;
		
		// 모든 강의 목록 list로 던져주기
		// session에서 로그인 타입과 객체 불러오기
		HttpSession session = request.getSession(false);
		student = (Student) session.getAttribute("info");
		int cIdx = Integer.parseInt(request.getParameter("cIdx"));
		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			cDao.deleteMyCourse(conn, cIdx, sIdx);
			
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
		request.setAttribute("resultCnt", resultCnt);
		
		return "/WEB-INF/views/student/sClassResult.jsp";
	}

}
