package phoneversion02;

import java.util.Scanner;

import phoneversion01.PhoneInfo;
/*
	전화번호 정보를 저장하는 기능만을 포함하는 클래스
	
	1. 사용자로부터 데이터를 받아서 인스턴스를 생성하고 반환하는 기능
   
 */

public class PhoneInfoManager {

	PhoneInfo info = null;
	
	Scanner sc = new Scanner(System.in);
	
		PhoneInfo createInstance() {
		
		System.out.println("친구의 정보를 저장하기 위한 데이터를 입력합니다");
	
		System.out.println("이름을 입력해주세요.");
		String name = sc.nextLine();
		
		System.out.println("전화번호를 입력해주세요");
		String num = sc.nextLine();
		
		System.out.println("생일을 입력해주세요");
		String day = sc.nextLine();
		
		// 사용자의 입력 데이터에 따라 인스턴스 생성 방법을 구분
		if(day==null||day.trim().isEmpty()) {
			info = new PhoneInfo(name, num);
		} else {
			info = new PhoneInfo(name, num, day);
		}
		
		
		return info;
		
	}
	
}
