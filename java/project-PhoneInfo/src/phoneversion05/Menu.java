package phoneversion05;

public class Menu {

	public static void showMenu() {
		System.out.println("=============");
		System.out.println("메뉴를 입력하세요");
		System.out.println(" "+MenuInterface.INSERT_INFO+". 친구 정보 입력");
		System.out.println(" "+MenuInterface.INFO_SERCH+". 친구 정보 검색");
		System.out.println(" "+MenuInterface.INFO_DELETE+". 친구 정보 삭제");
		System.out.println(" "+MenuInterface.INFO_EDIT+". 친구 정보 수정");
		System.out.println(" "+MenuInterface.SHOW_ALL+". 친구 정보 전체보기");
		System.out.println(" "+MenuInterface.EXIT+". 프로그램 종료");
		System.out.println("=============");
	}
	
}
