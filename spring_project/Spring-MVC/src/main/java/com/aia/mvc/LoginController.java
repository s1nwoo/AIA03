package com.aia.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.login.model.LoginRequest;

@Controller
@RequestMapping("/login/login") // http://localhsot:8080/mvc/login/login
public class LoginController {

	// get 방식의 요청에 대한 처리 -> 로그인 폼 페이지
	@RequestMapping(method = RequestMethod.GET)
	public String getLoginForm() {
		return "login/loginForm"; // WEB-INF/views/login/loginForm.jsp

	}

	// Post 방식의 요청 처리 메서드
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest request, @RequestParam("uid") String userId, @RequestParam("upw") String userPw, LoginRequest loginRequest) {
		
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		System.out.println("아이디 "+uid);
		System.out.println("비밀번호 "+upw);
		
		System.out.println("----------------------");
		
		System.out.println(userId);
		System.out.println(userPw);
		
		System.out.println("----------------------");
		
		System.out.println(loginRequest.getUid());
		System.out.println(loginRequest.getUpw());
		
		return "login/login";
		
	}
	
	
}
