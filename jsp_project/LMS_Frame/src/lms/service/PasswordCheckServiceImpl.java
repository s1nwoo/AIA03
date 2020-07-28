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

public class PasswordCheckServiceImpl implements Service {

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
			// student 객체에서 sIdx 가져오기
		
		// form에서 입력한 pw1, pw2 가져오기 
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		
		System.out.println("로그인 타입 : " + type);
		System.out.println("비밀번호 : " + pw1+ " / 체크 비밀번호 : " + pw2);
		
		// 변수 초기화
		String path = null;
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			if(type.equals("sLogin") && (pw1.equals(pw2))) {
				
				result = 1;
				System.out.println("result : " + result);
				request.setAttribute("chkResult", result);
				
				// 비밀번호가 일치할 때 (학생 로그인)
				path = "/WEB-INF/views/student/sInfo.jsp";
				
			} else if(type.equals("sLogin") && !(pw1.equals(pw2))){
				
				// 비밀번호가 불일치할 때
				path = "/WEB-INF/views/student/sInfo.jsp";
				
			} else if(type.equals("tLogin") && (pw1.equals(pw2))) {
				
				result = 1;
				System.out.println("result : " + result);
				request.setAttribute("chkResult", result);
				
				// 비밀번호가 일치할 때 (강사 로그인)
				path = "/WEB-INF/views/teacher/tInfo.jsp";
				
			} else if (type.equals("tLogin") && !(pw1.equals(pw2))){
				
				// 비밀번호가 불일치할 때
				path = "/WEB-INF/views/teacher/tInfo.jsp";
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
		
		
		return path;
	}

}
