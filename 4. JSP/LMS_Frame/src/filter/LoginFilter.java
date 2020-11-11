package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {	
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 1. request 파라미터를 이용하여 요청의 필터 작업 수행
		// (1) 현재 세션 객체를 확인
		HttpServletRequest httpRequest = (HttpServletRequest) request;	// ServletRequest > HttpServlet : 상위->하위 명시적 캐스팅
		// (2) 현재 세션의 객체
		HttpSession session = httpRequest.getSession(false);	// default: session 있으면 가져오기 없으면 생성하기, false: session 있으면 가져오고 없으면 null
		
		// (3) 로그인 유무 확인하는 변수
		boolean login = false;
		
		if(session != null) {
			if(session.getAttribute("info") != null) {
				login = true;
			}
		}
		
		// 2. 체인의 다음 필터 처리
		// 로그인이 되어있으면 다음 필터 처리로 이동
		if(login) {
			chain.doFilter(request, response);
		} else {	// 로그인이 안되어있다면 로그인 페이지로 이동
			// 포워딩할 페이지 경로
			// forward=server: context 경로 필요없음 
			// String path = "/member/sessionLoginForm.jsp";
			// RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			// dispatcher.forward(request, response);
			
			// 3. response를 이용하여 응답의 필터링 작업 수행
			// redirect=client: context 경로 필요
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			// String location = httpRequest.getContextPath()+"/views/loginForm.jsp";
			String location = httpRequest.getContextPath()+"/index.do";
			System.out.println("filter location : " + location);
			httpResponse.sendRedirect(location);
		}
	}
	
	// 초기화
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	// 웹컨테이너에서 소멸
	@Override
	public void destroy() {

	}

}
