package ex;

public class JDCBTest5 {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statemen stmt = null;
		PreparedStatement 

		
		
		try {
			// 0 드라이버 lib 추가
			// 1. 데이터베이스 드라이버 로드
			// Class.forName(드라이버 클래스 전체이름)
			// Orcle : oracle.jdbc.driver.OracleDriver
			Class.forName("oracle.jdbc.driver.OracleDriver")
		} catch {
			
		}
		
		// 2. 데이터베이스 연결
		// String url = "jdbc:oracle:thin:@주소:포트:데이터베이스이름";
		// 주소 : localhost or 127.0.0.1
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		Stirng user = "scott";
		String pw = "tiger";
		
		// Connection 객체 생성 
		
		
		
		
		// 3. SQL 처리
		
		
		
		// 4. 데이터베이스 연결 종료
		
	}

}
