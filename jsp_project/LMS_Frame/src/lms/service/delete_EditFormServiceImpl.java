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

public class delete_EditFormServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	Student student;
	Teacher teacher;
	StudentDao sDao;
	TeacherDao tDao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		// session에서 로그인 타입과 객체 불러오기
		HttpSession session = request.getSession(false);
		String type = (String) session.getAttribute("loginType");
		
		// form에서 입력한 전화번호와 이메일 가져오기
		String upw = request.getParameter("pw");
		
		// 변수 초기화
		int resultCnt = 0;
		Connection conn = null;
		String pw = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			sDao = StudentDao.getInstance();
			tDao = TeacherDao.getInstance();
			
			if(type.equals("sLogin")) {
				student = (Student) session.getAttribute("info");
				pw = student.getPw();
				
				if(upw.equals(pw)) {
					resultCnt = 1;
				}
			} else if(type.equals("tLogin")) {
				teacher = (Teacher) session.getAttribute("info");
				pw = teacher.getPw();
				
				if(upw.equals(pw)) {
					resultCnt = 2;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("resultCnt", resultCnt);
		return "/WEB-INF/views/editFormResult.jsp";
	}

}
