package lms.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	// Cookie 목록을 Map에 저장해서 관리
	private Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
	
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
		// 쿠키 갯수만큼 반복하여 Map에 저장
		for(int i=0; i<cookies.length; i++) {
			// Map 데이터 저장
			cookieMap.put(cookies[i].getName(), cookies[i]);
		}
	}
	
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	public String getValue(String name) {
		Cookie cookie = getCookie(name);
		String result = null;
		
		if(cookie!=null) {
			result = cookie.getValue();
		}
		return result;
		// return cookieMap.get(name).getValue();
	}
	
	public boolean exist(String name) {
		return cookieMap.get(name) != null;
	}
	
	// Cookie 객체 생성
	public static Cookie createCookie(String name, String value) {
		return new Cookie(name, value);
	}
	
	public static Cookie createCookie(String id, String value, String path, int maxAge) {
		Cookie c = new Cookie(id, value);
		c.setPath(path);
		c.setMaxAge(maxAge);
		
		return c;
	}
}
