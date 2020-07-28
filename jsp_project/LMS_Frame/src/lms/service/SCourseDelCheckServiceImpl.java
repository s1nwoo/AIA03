package lms.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Course;
import lms.model.MyCourse;
//import lms.model.SMyCourseListView;
import lms.model.Student;

public class SCourseDelCheckServiceImpl implements Service {

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
		//System.out.println("cidx : "+cIdx);
		
		
		Connection conn= null;
		int resultCnt = 0;
		String result = "N";
		
		myCourse = new MyCourse(sIdx, cIdx);
		
		try {
			conn=ConnectionProvider.getConnection();
			dao=CourseDao.getInstance();

			resultCnt=dao.deleteMyCourse(conn, cIdx, sIdx);
			
			if(resultCnt>0) {
				
				result="Y";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("delResult : "+result);
		request.setAttribute("delResult", result);
		
		
		return "/WEB-INF/views/student/sDelResult.jsp";
	}

}
