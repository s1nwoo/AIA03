package lms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbcp.ConnectionProvider;
import lms.dao.CourseDao;
import lms.model.Course;

public class CsearchServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	
	CourseDao cDao;
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		Connection conn = null;
		List<Course> courseList = null;
		String cName = request.getParameter("cname");
		
		try {
			conn = ConnectionProvider.getConnection();
			cDao = CourseDao.getInstance();		
			
			courseList = cDao.selectCourseByNameList(conn, cName);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		request.setAttribute("courseList", courseList);
		
		return "/WEB-INF/views/cSearchResult.jsp";
	}

}
