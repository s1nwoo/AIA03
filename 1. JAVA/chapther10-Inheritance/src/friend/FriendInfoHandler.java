package friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {

	// 2020.04.28
	// 수정사항: 싱글톤 처리
	//1-1 생성자 접근제어지시자 : private
	//	   인스턴스 생성 금지
	//1-2 공동으로 사용할 인스턴스 생성 : static private
	//1-3 참조변수 반환 메서드 : static public
	
	private static FriendInfoHandler handler = new FriendInfoHandler(100);
	
	public static FriendInfoHandler getInstance() {
		return handler;
	}
	
	// Friend 타입의 정보를 저장할 배열을 가진다.
	// 친구정보를 저장하는 기능
	// 친구정보의 기본 정보 출력 기능
	// 친구정보 상세 정보 출력 기능
	
	
	private Friend[] myFriends;	// Friend 타입의 배열 선언
	
	// List 참조변수
	
//	private ArrayList<Friend> myFriends;
	
	private int numOfFriend;	// 저장된 친구의 정보개수
	
	Scanner kb;
	
	// 초기화: 저장공간(사이즈) 크기를 받아서 배열 생성
	private FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriend=0;
		
		// ArrayList 인스턴스 생성
//		myFriends = new ArrayList<Friend>();
		
		kb = new Scanner(System.in);
	}
	
	// 친구정보를 저장하는 기능
	// 1. 배열에 저장하는 기능
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	
	// 1. 배열에 저장하는 기능
	void addFreindInfo(Friend f) {
		// 배열에 저장
		myFriends[numOfFriend]=f;
		numOfFriend++;
		
//		myFriends.add(f);
		
	}
	
	// 2. 사용자에게 데이터를 받아 사용자 요청에 맞는 인스턴스 생성
	// HeightFriend / UnivFriend
	void addFreind(int choice) {
		
		// 기본정보 받기
		System.out.println("이름을 입력하세요");
		String name = kb.nextLine();
		System.out.println("번호를 입력하세요");
		String phoneNum = kb.nextLine();
		System.out.println("주소를 입력하세요");
		String addr = kb.nextLine();
		
		Friend friend = null;
		
		if(choice==1) {
			// 1 일 때 정보 받기
			System.out.println("직업을 입력하세요");
			String work = kb.nextLine();
			// HeightFriend 인스턴스 생성
			friend = new HeighFriend(name, phoneNum, addr, work);
		} else {
			// 2 일 때 정보 받기
			System.out.println("전공을 입력하세요");
			String major = kb.nextLine();
			System.out.println("학년을 숫자로 입력하세요");
			String grade = kb.nextLine();
			
//			Integer.parseInt(grade); : String -> int
			
			// UnivFriend 인스턴스 생성
			friend = new UnivFriend(name, phoneNum, addr, major, Integer.parseInt(grade));
			
		}
		
		

		// addFriendInfo 호출
		addFreindInfo(friend);
		
	}
	
	// 친구정보의 기본 정보 출력 기능
	void showAllSimpleData() {
		
		System.out.println("=== 친구의 기본 정보를 출력합니다 ===");
		
		for(int i=0; i<numOfFriend; i++){
			myFriends[i].showBasicInfo();
			System.out.println("---------------");
		}
		
	}
	
	// 친구정보 상세 정보 출력 기능
	void showAllData() {
		System.out.println("=== 친구의 모든 정보를 출력합니다 ===");
		
		for(int i=0; i<numOfFriend; i++) {
			myFriends[i].showData();
			System.out.println("---------------");
		}
		
		
	}
	
}
	