package phoneversion04;


public class PhoneMain {

	public static void main(String[] args) {
		PhoneInfoHandler handler = new PhoneInfoHandler(100);
		
		while(true) {
			
			Menu.showMenu();
			
			int choice = handler.kb.nextInt();
			handler.kb.nextLine(); // 앞의 버퍼 클리어
		
			switch(choice) {
			case 1: 
				handler.createInfo();
				break;
			case 2:
				handler.showInfo();
				break;
			case 3:
				handler.delteInfo();
				break;
			case 4:
				handler.editInfo();
				break;	
			case 5:
				handler.showAllData();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다");
				return;
				
			}
				
		}
		
	}

}