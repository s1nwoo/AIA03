package phoneversion05;

public class PhoneInfo {

	String name; 			// 이름
	String phoneNumber;		// 전화번호
	String address;			// 주소
	String email;			// 이메일
	
	public PhoneInfo(String name, String phoneNumber, String address, String email) {
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.address=address;
		this.email=email;
		
	}
	// 기본정보 출력
	public void showBasicInfo() {
		System.out.println("이름: "+name);
		System.out.println("번호: "+phoneNumber);
		System.out.println("주소: "+address);
		System.out.println("메일: "+email);
		
	}	
	// 전체정보 출력	
	// 상속 목적 오버라이딩할 메서드
	public void ShowData() {
		showBasicInfo();
	}
}
