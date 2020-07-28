package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

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

public class SAddFormCourseListServiceImpl implements Service {

	CourseDao dao;
	Course course;
	Student student;
	MyCourse myCourse;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		
		Connection conn= null;
		
		CourseListView cListView=null;
		List<Course> courseList = null;
		String listJson = null;
		int resultCnt = 0;
		String result = "N";
		
		try {
			
			conn=ConnectionProvider.getConnection();
			dao=CourseDao.getInstance();
			
			courseList = dao.courseList(conn);
			
			if(courseList==null) {
				
				System.out.println("courseList null!");
			}else {
			
			
			Gson gson = new Gson();
			
			// Java Object -> JSON
			listJson = gson.toJson(courseList);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("courseList", listJson);
		System.out.println("listjson : "+listJson);
		
		
		return "/WEB-INF/views/student/sAddFormCourseList.jsp";
	}

}
