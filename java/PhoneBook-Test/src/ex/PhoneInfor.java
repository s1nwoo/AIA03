package ex;

public class PhoneInfor {

	String name; // 이름
	String phoneNumber; // 번호
	String email; // 이메일
	
	// 인스턴스 변수 초기화
	public PhoneInfor(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	// 기본정보 출력
	public void showBasicData() {
		System.out.println("이름 : "+name);
		System.out.println("번호 : "+phoneNumber);
		System.out.println("이메일 : "+email);
	}
		
	
	
}
