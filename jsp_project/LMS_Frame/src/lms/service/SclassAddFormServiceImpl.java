package lms.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SclassAddFormServiceImpl implements Service {

	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	
	@Override
	public String getViewPage(HttpServletRequest request, HttpServletResponse response) {
		
		/*
		 * Student student = null; Connection conn = null; List<Course> myList = new
		 * ArrayList<>(); List<Course> courseList = new ArrayList<>();
		 * 
		 * // 모든 강의 목록 list로 던져주기 // session에서 로그인 타입과 객체 불러오기 HttpSession session =
		 * request.getSession(false); student = (Student) session.getAttribute("info");
		 * 
		 * int sIdx = student.getsIdx();
		 * 
		 * try { conn = ConnectionProvider.getConnection();
		 * 
		 * myList = cDao.selectMyCourseBysIdx(conn, sIdx); courseList =
		 * cDao.courseList(conn);
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally { if(conn != null)
		 * { try { conn.close(); } catch (SQLException e) { e.printStackTrace(); } } }
		 * request.setAttribute("myList", myList); request.setAttribute("courseList",
		 * courseList);
		 * 
		 * System.out.println("여기가 courseList : "+courseList);
		 */
		
		return "/WEB-INF/views/student/sClassAddForm.jsp";
	}

}
