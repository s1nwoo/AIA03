package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lms.service.Service;



public class FrontController extends HttpServlet {
	
	private Map<String, Service> commands = new HashMap<String, Service>();
	
	

    @Override
   // 프로퍼티 파일에서 키값과 클래스 정보를 추출하여 그것을 Map에 저장합니다.
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    	
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		
		String path = "/WEB-INF/command.properties";
		String configFile = config.getServletContext().getRealPath(path);
		
		try {
			fis = new  FileInputStream(configFile);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator itr = prop.keySet().iterator();
		
		while(itr.hasNext()) {
			String command = (String) itr.next();
			String serviceClassName = prop.getProperty(command);
			
			try {
				Class serviceClass = Class.forName(serviceClassName);
				
				Service service = (Service) serviceClass.newInstance();
				
				commands.put(command, service);
				
				// 요청경로 = 서비스 등록 확인
				System.out.println("요청경로-서비스 확인용:"+command + "=" + service );
				
			} catch (ClassNotFoundException e) {
				
			} catch (InstantiationException e) {
				
			} catch (IllegalAccessException e) {
				
			}
		}
		
	}
    
    // 명령어에 따른 해당 service를 지정해줍니다.
   
    private void doCommandRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	// 넘어온 command 를 추출하는 과정입니다.
    	String type = null;
    	String command = request.getRequestURI();
    	
    	if (command.indexOf(request.getContextPath()) == 0) {
    		type = command.substring(request.getContextPath().length());
    	}
    	
    	// 요청경로 확인용출력
    	System.out.println("요청 파악 : " + type);
    	
    	
    	Service service = commands.get(type);
    	
    	// service가 Null일때 페이지를 만들어야... 할까용?
    	 
    	String page = service.getViewPage(request, response);
    	
    	// 추출한 명령어에 따라 화면 이동을 해줍니다.
    	// forward : 현재 실행중인 페이지와 forward에 의해 호출될 페이지는 request와 response를 공유합니다.
    	// sendRedirect : 새로운 페이지에서는 request와 response 객체가 새롭게 생겅됩니다.
    	// 근데 sendRedirect를 사용할 곳이 있을까 싶어서 일단 forward 작업만 했습니다.
    	RequestDispatcher dispatcher = request.getRequestDispatcher(page);
    	dispatcher.forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommandRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doCommandRequest(request, response);
	}

}
