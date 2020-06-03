package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.sun.org.apache.bcel.internal.classfile.PMGClass;

import manager.ConnectionProvider;
import manager.Dept;

public class PhoneDao {

	public int insertInfor(PhoneInfor pi) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {
			conn = ConnectionProvider.getConnection();

			String sql="insert into contact values "
					+ "(contact_pidx_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pi.getName());
			pstmt.setString(2, pi.getPhonenumber());
			pstmt.setString(3, pi.getAddress());
			pstmt.setString(4, pi.getEmail());
			pstmt.setString(5, pi.getCategory());
			pstmt.setString(6, pi.getMajor());
			pstmt.setString(7, pi.getGrade());
			pstmt.setString(8, pi.getCompany());
			pstmt.setString(9, pi.getDept());
			pstmt.setString(10, pi.getJob());
			pstmt.setString(11, pi.getCafename());
			pstmt.setString(12, pi.getNickname());

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

	
	public List<PhoneInfor> searchInfor(String name) {
		
		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<PhoneInfor> list = new ArrayList<PhoneInfor>();

		try {

			conn = ConnectionProvider.getConnection();


			String sql = "select * from contact where name like '%'||?||'%'";
			// String sql = "select * from dept where dname=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				list.add(new PhoneInfor(
						rs.getString("name"), 
						rs.getString("phonenumber"), 
						rs.getString("address"), 
						rs.getString("email"), 
						rs.getString("category"), 
						rs.getString("major"), 
						rs.getString("grade"), 
						rs.getString("company"), 
						rs.getString("dept"), 
						rs.getString("job"),
						rs.getString("cafename"),
						rs.getString("nickname")));

			}

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
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

		return list;

	}

	
	public int deleteInfor(String name) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			String sql = "delete from contact where name=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			resultCnt = pstmt.executeUpdate();

			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
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
	
	
	public int editInfor(PhoneInfor newPi) {

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int resultCnt = 0;

		try {

			// Connection 객체 생성
			conn = ConnectionProvider.getConnection();

			// 3. SQL 처리
			// Statement or PreparedStatement
			// pstmt = conn.prepareStatement(SQL 문장)

			// 주의 !!!!!
			// 입력된 수정하고자 하는 이름의 데이터가 존재해야 수정 데이터 입력이 시작시킵니다.
			// 그리고 이름의 데이터는 유일조건이 있어야 합니다.
			// 유일조건이 아니라면 여러개의 행에 수정 처리가 이루어집니다.
			// 현재 버전에서는 유일한 값으로 생각하고 처리합니다.

			stmt = conn.createStatement();

			String sql = "update contact set name=?, phonenumber=?, address=?,email=?,category=?,major=?,grade=?,company=?,dept=?,job=?,cafename=?,nickname=?";
			

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, newPi.getName());
			pstmt.setString(2, newPi.getPhonenumber());
			pstmt.setString(3, newPi.getAddress());
			pstmt.setString(4, newPi.getEmail());
			pstmt.setString(5, newPi.getCategory());
			pstmt.setString(6, newPi.getMajor());
			pstmt.setString(7, newPi.getGrade());	
			pstmt.setString(8, newPi.getCompany());
			pstmt.setString(9, newPi.getDept());
			pstmt.setString(10, newPi.getJob());
			pstmt.setString(11, newPi.getCafename());
			pstmt.setString(12, newPi.getNickname());
			

			resultCnt = pstmt.executeUpdate();


			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
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

			if (stmt != null) {
				try {
					stmt.close();
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
	
	
	public int phoneSeachCount(String searchName) {

		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int rowCnt = 0;

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select count(*) from contact where name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				rowCnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCnt;
	}
	
	
	public PhoneInfor phoneSearchName(String searchName) {

		PhoneInfor pi = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();

			String sql = "select * from contact where name = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchName);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				pi = new PhoneInfor(
						
						rs.getString("name"),
						rs.getString("phonenumber"),
						rs.getString("address"),
						rs.getString("email"),
						rs.getString("category"),
						rs.getString("major"),
						rs.getString("grade"),
						rs.getString("company"),
						rs.getString("dept"),
						rs.getString("job"),
						rs.getString("cafename"),
						rs.getString("nickname"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pi;

	}

	
	public List<PhoneInfor> listInfor() {

		// VO : Value Object, read only, getter (읽기전용)
		// DTO : Data Transfer Object getter/setter, toString, equals

		// JDBC 사용 객체
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Dao 클래스 추가
		List<PhoneInfor> listInfor = new ArrayList<>();

		// 공백 입력에 대한 예외처리가 있어야 하나 이번 버전에서는 모두 잘 입력된것으로 처리합니다.

		try {
			// 2. 데이터베이스 연결
			conn = ConnectionProvider.getConnection();

			String sql = "select * from contact";

			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				PhoneInfor pi = new PhoneInfor(
						rs.getString("name"),
						rs.getString("phonenumber"),
						rs.getString("address"),
						rs.getString("email"),
						rs.getString("category"),
						rs.getString("major"),
						rs.getString("grade"),
						rs.getString("company"),
						rs.getString("dept"),
						rs.getString("job"),
						rs.getString("cafename"),
						rs.getString("nickname"));
						
	
				listInfor.add(pi);

//				System.out.print(rs.getInt("deptno") + "\t");
//				System.out.printf("%15s", rs.getString("dname") + "\t");
//				System.out.printf("%15s", rs.getString("loc") + "\n");
//				resultCnt++;
			}


			// 4. 데이터베이스 연결 종료
			// pstmt.close();
			// conn.close();

		} catch (SQLException e) {
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
		return listInfor;

	}
	
}
