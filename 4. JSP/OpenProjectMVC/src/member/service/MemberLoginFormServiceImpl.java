package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import member.dao.MemberDao;

public class MemberLoginFormServiceImpl implements Service {

	MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		return "/WEB-INF/views/member/loginForm.jsp";
	}

}









