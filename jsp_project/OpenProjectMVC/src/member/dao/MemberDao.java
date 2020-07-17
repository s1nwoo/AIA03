package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.Member;

public class MemberDao {

	private MemberDao() {
	}

	private static MemberDao dao = new MemberDao();

	public static MemberDao getInstance() {
		return dao;
	}

	public int insertMember(Connection conn, Member member) throws SQLException {
		int resultCnt = 0;

		PreparedStatement pstmt = null;
		String sql = "INSERT INTO project.member (uid, upw, uname, uphoto ) VALUES (?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUid());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUphoto());

			resultCnt = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int selectById(Connection conn, String id) throws SQLException {

		int resultCnt = 0;

		PreparedStatement pstmt = null;
		ResultSet rs;

		try {
			String sql = "select count(*) from project.member where uid=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				resultCnt = rs.getInt(1);
			}

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return resultCnt;
	}

	public int selectTotalCount(Connection conn) throws SQLException {
		int resultCnt = 0;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt=conn.createStatement();
			String sql = "select count(*) from project.member";
			
			rs=stmt.executeQuery(sql);
			
			if(rs.next()) {
				resultCnt=rs.getInt(1);
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
		}
		return resultCnt;
	}
	
	public List<Member> selectList(Connection conn, int startRow) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		
		List<Member> list = new ArrayList<Member>();
		
		try {
			String sql = "select * from project.member order by uname limit ?, 5";	// 시작점, 3개
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				member = new Member();
				member.setIdx(rs.getInt("idx"));
				member.setUid(rs.getString("uid"));
				member.setUpw(rs.getString("upw"));
				member.setUname(rs.getString("uname"));
				member.setUphoto(rs.getString("uphoto"));
				list.add(member);
			}
			
		} finally {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
		}
		return list;
	}
}
