package phoneversion05;

// 상속을 위한 기본 클래스 구성
public abstract class PhoneInfo implements Info {

	String name; // 이름
	String phoneNumber; // 전화번호
	String address; // 주소
	String email; // 이메일

	// 인스턴스 변수 초기화
	public PhoneInfo(String name, String phoneNumber, String address, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.email = email;
	}

	// 기본정보 출력
	public void showBasicInfo() {
		System.out.println("이름: " + name);
		System.out.println("번호: " + phoneNumber);
		System.out.println("주소: " + address);
		System.out.println("메일: " + email);
	}

	// 수정일시: 2020.04.29
	// 수정내용: interface 구현으로 메서드 오버라이딩 생략
	// 전체정보 출력
	// 상속 목적 오버라이딩할 메서드
//	public void ShowData() {
//		showBasicInfo();
//		}
}
