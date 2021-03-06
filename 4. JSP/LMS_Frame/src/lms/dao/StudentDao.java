package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lms.model.Student;

public class StudentDao {

	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	// 학생 DAO - 담당 : 김승연
	// 작업 일시 : 2020. 07. 21
	private StudentDao() {

	}

	private static StudentDao dao = new StudentDao();

	public static StudentDao getInstance() {
		return dao;
	}

	// 학생 정보 수정 메서드
	// update 쿼리문이 성공적으로 싱행되면
	// int값을 반환해 result 값에 저장하여 반환

	// 학생 정보 등록 : insert
	public int insertStudent(Connection conn, Student student) throws SQLException {

		int result = 0;

		// sql 쿼리문을 처리할 statement를 설정합니다.
		PreparedStatement pstmt = null;

		// 처리하고 싶은 sql 쿼리문과 조건을 설정합니다.
		// 이런 테이블이 있다는 가정하에 작성한 spl문
		String sql = "INSERT INTO project.student (sIdx, pw, name, tel, email, major, grade) "
				+ "	VALUES(?, ?, ?, ?, ?, ?, ?);";

		try {

			// sql문을 실행합니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getsIdx());
			pstmt.setString(2, student.getPw());
			pstmt.setString(3, student.getName());
			pstmt.setString(4, student.getTel());
			pstmt.setString(5, student.getEmail());
			pstmt.setString(6, student.getMajor());
			pstmt.setInt(7, student.getGrade());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 학생 내정보 보기 : select
	public int selectStudent(Connection conn, Student student) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			// 학번으로 내 정보 확인
			String sql = "SELECT * FROM project.student where sIdx=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getsIdx());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 학생 내정보 수정 : update
	public int editStudent(Connection conn, int sIdx, String tel, String email) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;

		// 수정사항 : 전화번호/이메일
		String sql = "update project.student set tel=?, email=? where sIdx=?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, email);
			pstmt.setInt(3, sIdx);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 관리자의 학생 전체정보 수정 : update
		public int editStudentByAdmin(Connection conn, int sIdx, String pw, String name, String major, int grade, String tel, String email) throws SQLException {

			int result = 0;

			PreparedStatement pstmt = null;

			// 수정사항 : 전화번호/이메일
			String sql = "update project.student set sIdx=?, pw=?,name=?,major=?,grade=?email=? where sIdx=?;";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, sIdx);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.setString(4, major);
				pstmt.setInt(5, grade);
				pstmt.setString(6, tel);
				pstmt.setString(7, email);
				pstmt.setInt(8, sIdx);

				result = pstmt.executeUpdate();

			} finally {
				if (pstmt != null) {
					pstmt.close();
				}
			}

			return result;

		}
	
	// 학생 내정보 삭제 : delete
	public int deleteStudent(Connection conn, int sIdx) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from project.student where sIdx=?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sIdx);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	// 학생 정보 전체 리스트 : ArrayList
	public List<Student> studentList(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs;

		List<Student> studentList = new ArrayList<Student>();

		String sql = "SELECT * FROM project.student;";

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Student student = new Student();
				student.setsIdx(rs.getInt("sIdx"));
				student.setPw(rs.getString("pw"));
				student.setName(rs.getString("name"));
				student.setTel(rs.getString("tel"));
				student.setEmail(rs.getString("email"));
				student.setMajor(rs.getString("major"));
				student.setGrade(rs.getInt("grade"));

				studentList.add(student);
			}

		} finally {

			if (stmt != null) {
				stmt.close();
			}

		}

		return studentList;
	}

	// 학생 이름으로 조회
	public Student selectStudentByIdx(Connection conn, int sIdx) throws SQLException {

		Student studentInfo = null;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {

			String sql = "SELECT * FROM project.student where sIdx=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				studentInfo = new Student(rs.getInt("sIdx"),
										rs.getString("pw"),
										rs.getString("name"),
										rs.getString("tel"),
										rs.getString("email"),
										rs.getString("major"),
										rs.getInt("grade"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return studentInfo;

	}

	// sIdx와 pw를 통해 학생 정보 select : 로그인에 사용하세용?
	public Student selectBysIdPw(Connection conn, int sIdx, String pw) throws SQLException {

		PreparedStatement pstmt = null;

		ResultSet rs;

		Student student = null;

		try {

			String sql = "select * from project.student where sIdx=? and pw=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sIdx);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				student = new Student(
										rs.getInt("sIdx"),
										rs.getString("pw"),
										rs.getString("name"),
										rs.getString("tel"),
										rs.getString("email"),
										rs.getString("major"),
										rs.getInt("grade"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

		}

		return student;
	}
	
	public int checkLoginStudent (Connection conn, int sIdx, String pw) throws SQLException {
		
		int checkLogin = 0;
		
		
		PreparedStatement pstmt = null;
		
		// 박혜미 추가코드 200724
		ResultSet rs = null;
		
		try {
			
			// 원본
			// String sql = "select * from project.student where sIdx=? and pw=?;";
			
			// 박혜미 수정코드 200724 : count로 변경하고
			String sql = "select count(*) from project.student where sIdx=? and pw=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sIdx);
			pstmt.setString(2, pw);
			
			// 원본
			// checkLogin = pstmt.executeUpdate();
			
			// 박혜미 수정코드 200724 : executeUpdate() ㅡ> executeQuery() ..select문이므로 메서드 변경하고. rs.next()로 확인 후 카운트 
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
				checkLogin = rs.getInt(1); 
			}
			 		
			
			
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			
		}
		
		return checkLogin;	
	}

}
