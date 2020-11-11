package phoneversion03;

import java.util.Scanner;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		PhoneInfoManager manager = new PhoneInfoManager();		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {

			Menu.showMenu();
			
			// swith문 선택할 스캐너 입력
			int selectNum = sc.nextInt();
			sc.nextLine();
					
				switch(selectNum) {
				case 1:
					// 사용자의 입력 데이터를 인스턴스 생성
//					PhoneInfo info = manager.createInstance();
//					manager.addInfo(info);
					// 정보를 배열에 저장
					manager.addInfo();
					break;
				case 2:
					// 이름으로 검색
					manager.searchInfo();
					break;
				case 3:
					// 이름으로 검색후 삭제
					manager.deleteInfo();
					break;
				case 4:
					// 전체 리스트 출력
					manager.showAllData();
					break;
				case 5:
					//return;
					System.out.println("프로그램이 종료되었습니다.");
					System.exit(0);
					
					break;
				}
					

//			// 사용자의 입력 데이터를 인스턴스 생성
//			info = manager.createInstance();
//			// 정보를 배열에 저장
//			manager.addInfo(info);
//			// 전체 리스트 출력
//			manager.showAllData();
//			// 이름으로 검색
//			manager.searchInfo();
//			// 이름으로 검색후 삭제
//			manager.deleteInfo();
//			manager.showAllData();
			
		}

	}

}