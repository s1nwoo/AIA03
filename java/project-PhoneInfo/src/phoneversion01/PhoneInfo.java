package phoneversion01;

/*
	Version 0.1 전화번호 관리 프로그램. 
	PhoneInfor 라는 이름의 클래스를 정의해 보자. 클래스는 다음의 데이터들의 문자열 형태로 저장이 가능 해야 하며, 저장된 데이터의 적절한 출력이 가능하도록 메소드 정의
	• 이름             name            String
	• 전화번호       phoneNumber     String
	• 생년월일       birthday        String 
	단, 생년월일 정보는 저장할 수도 있고, 저장 않을 수도 있게끔 생성자 생성.
 */

public class PhoneInfo {

	String name; // String 타입의 name 변수 설정(이름)
	String phoneNumber; // String 타입의 phoneNumber 변수 설정(전화번호)
	String brithday; // String 타입의 brithday 변수 설정(생년월일)

	// 초기화를 위한 생성자
	public PhoneInfo(String name, String num, String day) {
		this.name = name;
		this.phoneNumber = num;
		this.brithday = day;
	}

	// 생년월일 저장 안할 시 호출하는 초기화 생성자
	public PhoneInfo(String name, String num) {
//		this.name = name;
//		this.phoneNumber = num;
//		this.brithday = "[미입력]";
		this(name, num, "미입력");
	}

	// 출력 메서드 선언
	public void showData() {
		System.out.println("이      름: " + name + "\n전화번호: " + phoneNumber + "\n생년월일: " + brithday);
		System.out.println("-------------------");
	}

}