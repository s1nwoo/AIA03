package phoneversion05;


public class PhoneMain {

	public static void main(String[] args) {
		
		PhoneInfoHandler handler = PhoneInfoHandler.getInstace();
		
		while(true) {
			
			Menu.showMenu();
			
			int choice = handler.kb.nextInt();
			handler.kb.nextLine(); // 앞의 버퍼 클리어
		
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