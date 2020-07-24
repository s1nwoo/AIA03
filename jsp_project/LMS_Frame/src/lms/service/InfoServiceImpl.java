package lms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InfoServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		// session에서 로그인 타입과 객체 불러오기
		HttpSession session = request.getSession(false);
		String type = (String) session.getAttribute("loginType");
		
		// 변수 초기화
		String path = null;
		

		if(type.equals("sLogin")) {			
			path = "/WEB-INF/views/student/sInfo.jsp";
		} else if(type.equals("tLogin")){
			path = "/WEB-INF/views/teacher/tInfo.jsp";
		}
		
		return path;
	}

}
