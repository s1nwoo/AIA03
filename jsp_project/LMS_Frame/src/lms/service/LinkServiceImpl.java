package lms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServiceImpl implements Service {
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// Front Controller에 view 페이지를 요청합니다.
		return "/WEB-INF/views/scheduleLink.jsp";
	}


}
