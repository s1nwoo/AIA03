package lms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TempletFormServiceImpl implements Service {

	// Service 클래스 이용에 대한 예제 클래스입니다.
	
	
	@Override
	// 
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// Front Controller에 view 페이지를 요청합니다.
		return "/WEB-INF/view/templetForm.jsp";
	}


}
