package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.TempletDao;
import lms.model.TempletModel;

public class TempletServiceImpl implements Service {

	// Service 클래스 이용에 대한 예제 클래스입니다.
	
	// 데이터 베이스에 접근해 줄 Dao 클래스를 불러옵니다.
	TempletDao dao;
	
	@Override
	// 
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String result = "N";
		
		String a = null;
		String b = null;
		
		Connection conn = null;
		
		try {
			TempletModel templet = new TempletModel();
			
			templet.setA(a);
			templet.setB(b);
			
			conn = ConnectionProvider.getConnection();
			
			dao = TempletDao.getInstance();
			
			result = dao.insertAB(conn, templet);
			
			request.setAttribute("templet", templet);
			request.setAttribute("result", result);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		
		// Front Controller에 view 페이지를 요청합니다.
		return "/WEB-INF/view/templet.jsp";
	}


}
