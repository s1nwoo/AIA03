package phoneversion06;

import java.util.InputMismatchException;

import phoneversion05.exception.BadNumberException;
import phoneversion05.exception.StringEmptyException;

public class PhoneMain {

	public static void main(String[] args) {
		
		PhoneInfoHandler handler = PhoneInfoHandler.getInstace();
		
		while(true) {
			
			Menu.showMenu();
			
			int choice = 0;
			
			try {
				choice = handler.kb.nextInt();
				
				// 정상 범위는 1~6
				// MenuInterface.INSERT_INFO ~ MenuInterface.EXIT
				if(!(choice>=MenuInterface.INSERT_INFO && choice<=MenuInterface.EXIT)) {
					BadNumberException e = new BadNumberException("메뉴 범위를 벗어나는 번호입니다");
					
					// 강제적인 예외 발생
					throw e;
				}
				
			} catch(InputMismatchException e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
//				handler.kb.nextLine();
				continue;
			} catch(BadNumberException e) {
				System.out.println("메뉴 범위를 벗어난 숫자 입력입니다.\n다시 확인 후 입력하세요.");
				continue;
			} catch(Exception e) {
				System.out.println("잘못된 메뉴 입력입니다.\n숫자로 입력하세요.");
				continue;
			} finally {
				handler.kb.nextLine();
			}
			
//			handler.kb.nextLine(); // 앞의 버퍼 클리어
		
			switch(choice) {
			case MenuInterface.INSERT_INFO: 
				handler.createInfo();
				break;
			case MenuInterface.INFO_SERCH:
				handler.showInfo();
				break;
			case MenuInterface.INFO_DELETE:
				handler.delteInfo();
				break;
			case MenuInterface.INFO_EDIT:
				handler.editInfo();
				break;	
			case MenuInterface.SHOW_ALL:
				handler.showAllData();
				break;
			case MenuInterface.EXIT:
				System.out.println("프로그램을 종료합니다");
				return;
				
			}
				
		}
		
	}

}