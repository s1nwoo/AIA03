package ex;

import java.util.Scanner;

public class PhoneMain {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {

//Project ( 전화번호 관리 프로그램 ) ver 0.7

//데이터베이스를 이용해서 친구의 정보를 CRUD 하는 프로그램을 만들어 봅시다.
//- JDBC 이용
//- 테이블 생성 DDL 실행 ( 수업시간에 작성한 테이블을 이용해고 됩니다.)
//- 데이터 처리를 위한 질의와 DML 작성
//- 핵심기능 클래스와 DAO 클래스를 별도로 구현하는 구조로 작성해주세요.
		
		PhoneManager pm = new PhoneManager();
		
		// DB 드라이버 로드
		
//		Class.forName("orcal.jdbc.drive.OracleDriver");
//		System.out.println("DB 드라이버 로드 완료");
		
		while(true) {
			System.out.println("=======================");
			System.out.println("메뉴를 입력하세요");
			System.out.println("=======================");
			System.out.println("1. 친구 정보 입력");
			System.out.println("2. 친구 정보 검색");
			System.out.println("3. 친구 정보 삭제");
			System.out.println("4. 친구 정보 수정");
			System.out.println("5. 친구 목록 출력");
			System.out.println("6. 프로그램 종료");
			System.out.print("입력칸 : ");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				pm.insertImfor();
				break;
			case 2:
//				searchImfor();
				break;
			case 3:
//				deleteImfor();
				break;
			case 4:
//				editImfor();
				break;
			case 5:
//				listImfor();
				break;
			case 6:
				System.out.println("이용해주셔서 감사합니다.");
				return;
			}
			
		}
		
		
		
		
		
	}

}
