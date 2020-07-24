package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbcp.ConnectionProvider;

public class LoginServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// String type = cookieBox.getValue("type");
	
		HttpSession session = request.getSession();
		String type = (String) session.getAttribute("loginType");
		System.out.println("type :" +type);
		String path = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			if(type.equals("sLogin")) {
				path = "/WEB-INF/views/student/sMyPage.jsp";
			} else if(type.equals("tLogin")) {
				path = "/WEB-INF/views/teacher/tMyPage.jsp";
			} else {
				path = "/WEB-INF/views/admin/cList.jsp";
			}
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
