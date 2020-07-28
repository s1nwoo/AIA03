package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Course;
import lms.model.CourseListView;
import lms.model.MyCourse;
//import lms.model.SMyCourseListView;
import lms.model.Student;

public class SAddFormMyCourseListServiceImpl implements Service {

	CourseDao dao;
	Course course;
	Student student;
	MyCourse myCourse;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		CourseListView cListView=null;
		Connection conn= null;
		
		int resultCnt = 0;
		String result = "N";
		HttpSession session = request.getSession(false);
		student = (Student) session.getAttribute("info");
		
		//int sIdx = student.getsIdx();
		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		List<Course> myList = new ArrayList<>();
		String myListJson = null;
		System.out.println("sIdx :"+sIdx);
		try {
			
			conn=ConnectionProvider.getConnection();
			dao=CourseDao.getInstance();
			myList = dao.selectMyCourseBysIdx(conn, sIdx);
			System.out.println("inner sIdx :"+sIdx);
			
			
			if(myList==null) {
				
				System.out.println("myList null!");
			}else {
			
			
			Gson gson = new Gson();
			
			// Java Object -> JSON
			myListJson = gson.toJson(myList);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("myList", myListJson);
		System.out.println("myListJson : "+myListJson);
		
		
		return "/WEB-INF/views/student/sAddFormMyCourseList.jsp";
	}

}
