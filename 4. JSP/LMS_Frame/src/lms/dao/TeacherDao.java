package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lms.model.Teacher;

public class TeacherDao {

	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private TeacherDao() {

	}

	private static TeacherDao dao = new TeacherDao();

	public static TeacherDao getInstance() {
		return dao;
	}

	// 교수 정보 입력 : insert
	public int insertTeacher(Connection conn, Teacher teacher) throws SQLException {

		int result = 0;

		// sql 쿼리문을 처리할 statement를 설정합니다.
		PreparedStatement pstmt = null;

		// 처리하고 싶은 sql 쿼리문과 조건을 설정합니다.
		// 이런 테이블이 있다는 가정하에 작성한 spl문
		String sql = "INSERT INTO project.teacher (tIdx, pw, name, tel, email, major, job) "
				+ "	VALUES(?, ?, ?, ?, ?, ?, ?);";

		try {

			// sql문을 실행합니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacher.gettIdx());
			pstmt.setString(2, teacher.getPw());
			pstmt.setString(3, teacher.getName());
			pstmt.setString(4, teacher.getTel());
			pstmt.setString(5, teacher.getEmail());
			pstmt.setString(6, teacher.getMajor());
			pstmt.setString(7, teacher.getJob());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 교수 내정보 보기 : select
	public int selectTeacher(Connection conn, Teacher teacher) throws SQLException {

		int result = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			String sql = "SELECT * FROM project.teacher where tIdx=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacher.gettIdx());

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

	// 교수 내정보 수정 : update
	public int editTeacher(Connection conn, int tIdx, String tel, String email) throws SQLException {

		int result = 0;

		// sql 쿼리문을 처리할 statement를 설정합니다.
		PreparedStatement pstmt = null;

		// 처리하고 싶은 sql 쿼리문과 조건을 설정합니다.
		// 이런 테이블이 있다는 가정하에 작성한 spl문
		String sql = "UPDATE project.teacher set tel = ?, email = ? where tIdx = ?;";

		try {

			// sql문을 실행합니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tel);
			pstmt.setString(2, email);
			pstmt.setInt(3, tIdx);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

	// 교수 내정보 삭제 : delete
	public int deleteTeacher(Connection conn, int tIdx) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "delete from project.teacher where tIdx=?;";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tIdx);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	// 학생 정보 전체 리스트 : ArrayList
	public List<Teacher> teacherList(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs;

		List<Teacher> teacherList = new ArrayList<Teacher>();

		String sql = "SELECT * FROM project.teacher;";

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Teacher teacher = new Teacher(
												rs.getInt("tIdx"),
												rs.getString("pw"),
												rs.getString("name"),
												rs.getString("tel"),
												rs.getString("email"),
												rs.getString("major"),
												rs.getString("job"));

				teacherList.add(teacher);
			}

		} finally {

			if (stmt != null) {
				stmt.close();
			}

		}

		return teacherList;
	}

	// 교수 교번으로 조회
	public Teacher selectTeacherByIdx(Connection conn, int tIdx) throws SQLException {

		Teacher teacherInfo = null;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {

			String sql = "SELECT * FROM project.teacher where tIdx=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				teacherInfo = new Teacher(
										rs.getInt("tIdx"),
										rs.getString("pw"),
										rs.getString("name"),
										rs.getString("tel"),
										rs.getString("email"),
										rs.getString("major"),
										rs.getString("job"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return teacherInfo;

	}

	// tIdx와 pw를 통해 교사 정보 select : 로그인에 사용하세용?
	public Teacher selectBytIdPw(Connection conn, int tIdx, String pw) throws SQLException {

		PreparedStatement pstmt = null;

		ResultSet rs;

		Teacher teacher = null;

		try {

			String sql = "select * from project.teacher where tIdx=? and pw=?;";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tIdx);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				teacher = new Teacher(
										rs.getInt("tIdx"),
										rs.getString("pw"),
										rs.getString("name"),
										rs.getString("tel"),
										rs.getString("email"),
										rs.getString("major"),
										rs.getString("job"));
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}

		}

		return teacher;
	}

	public int checkLoginTeacher (Connection conn, int tIdx, String pw) throws SQLException {
		
		int checkLogin = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select count(*) from project.teacher where tIdx=? and pw=?;";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tIdx);
			pstmt.setString(2, pw);
			
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
