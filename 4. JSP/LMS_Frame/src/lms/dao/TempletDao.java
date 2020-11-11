package lms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import lms.model.TempletModel;

public class TempletDao {
	
	// 싱글톤 처리 완료
	// Dao 클래스 이용에 대한 예제클래스입니다.
	private TempletDao () {
		
	}
	
	private static TempletDao dao = new TempletDao();
	
	public static TempletDao getInstance() {
		return dao;
	}
	
	
	// MVC2 - FrontConnetcion/Command 패턴에서는 따로 Connection과 드라이브, 로그인 정보를 설정하지 않습니다.
	// 미리 설정한 Controller와 DBCP 클래스, ConnectionProvider 객체를 이용하여 DB와 엑세스합니다.
	// 데이터를 처리할 메서드를 구현합니다.
	
	public String insertAB (Connection conn, TempletModel TepModel) throws SQLException {
		
		String check = "N";
		
		// sql 쿼리문을 처리할 statement를 설정합니다.
		PreparedStatement pstmt = null;
		
		// 처리하고 싶은 sql 쿼리문과 조건을 설정합니다.
		// 이런 테이블이 있다는 가정하에 작성한 spl문
		String sql = "INSERT INTO project.ab (a, b) VALUES(?,?);";
		
		try {
			
			// sql문을 실행합니다.
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, TepModel.getA());
			pstmt.setString(2, TepModel.getB());
			
			int resultCnt = pstmt.executeUpdate();
			if (resultCnt != 0) {
				check = "Y";
			}
			
		} finally { 
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		
		return check;
		
	}
	
	
}
