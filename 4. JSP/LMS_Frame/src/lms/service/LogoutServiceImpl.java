package lms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		return "/WEB-INF/views/loginForm.jsp";
	}

}
