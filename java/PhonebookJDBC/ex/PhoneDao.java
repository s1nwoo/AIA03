package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import manager.ConnectionProvider;

public class PhoneDao {

	public int insertInfor(PhoneBasic pb) {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			String sql = "insert into phoneinfo_basic" + "(idx, fr_name, fr_phonenum, fr_email, fr_address) values (?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pb.getIdx());
			pstmt.setString(2, pb.getFr_name());
			pstmt.setString(3, pb.getFr_phonenum());
			pstmt.setString(4, pb.getFr_email());
			pstmt.setString(5, pb.getFr_address());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			// 4. 데이터베이스 연결 종료
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
		return resultCnt;
	}
	
}
