package ex;

import java.sql.Connection;

public class JDBCQ1 {

	public static void main(String[] args) {

//		1.EMP 테이블에 새로운 사원 정보를 입력하는 프로그램을 작성해보자.
		
		Connection conn = null;
		
		// DB 드라이버 로드
		Class.forName("orcale.jdbc.driver.OracleDriver");
		
		System.out.println();
		
		
		conn = DriverManger.getConnection(url, user, pw);
				
	}

}
