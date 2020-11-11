package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.TeacherDao;
import lms.model.Teacher;

public class TeditServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	Teacher teacher;
	TeacherDao tDao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		// form에서 입력한 전화번호와 이메일 가져오기
		int tIdx = Integer.parseInt(request.getParameter("tIdx"));	// name = "edit" 버튼을 누르면 table list에 있던 tIdx를 불러온다
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		
		// 변수 초기화
		Connection conn = null;
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			tDao = TeacherDao.getInstance();
			
			resultCnt = tDao.editTeacher(conn, tIdx, tel, email);
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
		return "/WEB-INF/views/admin/tList.jsp";
	}

}
