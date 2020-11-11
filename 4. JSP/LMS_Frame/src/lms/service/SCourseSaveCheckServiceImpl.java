package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Course;
//import lms.model.CourseListView;
import lms.model.MyCourse;
//import lms.model.SMyCourseListView;
import lms.model.Student;

public class SCourseSaveCheckServiceImpl implements Service {

	CourseDao dao;
	Course course;
	Student student;
	MyCourse myCourse;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {

		//HttpSession session = request.getSession(false);
		//student = (Student) session.getAttribute("info");
		
		//int sIdx = student.getsIdx();
		
		//System.out.println("sidx : "+sIdx);
		
		int sIdx = Integer.parseInt(request.getParameter("sIdx"));
		int cIdx = Integer.parseInt(request.getParameter("cIdx"));
		System.out.println("cidx : "+cIdx);
		
		
		//CourseListView cListView=null;
		Connection conn= null;
		int resultCnt = 0;
		String result = "N";
		//List<Course> courseList = null;
		
		myCourse = new MyCourse(sIdx, cIdx);
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=CourseDao.getInstance();

			resultCnt=dao.insertMyCourse(conn, sIdx, cIdx);
			
			if(resultCnt>0) {
				
				result="Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("saveResult", result);
		
		
		return "/WEB-INF/views/student/sSaveResult.jsp";
	}

}
