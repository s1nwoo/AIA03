package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lms.model.Teacher;
import lms.model.TempletModel;

public class TeacherDao {

	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private TeacherDao() {

	}

	private static TeacherDao dao = new TeacherDao();

	public static TeacherDao getInstance() {
		return dao;
	}

	// 교수 내정보 수정
	public int editTeacher(Connection conn, Teacher teacher) throws SQLException {

		int result = 0;

		// sql 쿼리문을 처리할 statement를 설정합니다.
		PreparedStatement pstmt = null;

		// 처리하고 싶은 sql 쿼리문과 조건을 설정합니다.
		// 이런 테이블이 있다는 가정하에 작성한 spl문
		String sql = "UPDATE teacher set tel = ?, email = ? where tIdx = ?";

		try {

			// sql문을 실행합니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTel());
			pstmt.setString(2, teacher.getEmail());
			pstmt.setInt(3, teacher.gettIdx());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;

	}

}
