package phoneversion01;

public class PhoneInfor {

	String name;
	String phoneNumber;
	String brithday;
	
	public PhoneInfor(String name, String num, String day) {
		this.name = name;
		this.phoneNumber = num;
		this.brithday = day;
	}
	
	public PhoneInfor(String name, String num) {
		this.name = name;
		this.phoneNumber = num;
		this.brithday = "[미입력]";
	}
	
	
	public void showData() {
		System.out.println("이름: " +name+"\n번호: "+phoneNumber+"\n생일: "+brithday);
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		
		PhoneInfor ph1 = new PhoneInfor("정신우", "010-xxxx-7317", "920928");
		PhoneInfor ph2 = new PhoneInfor("홍길동", "010-xxxx-4444");
		ph1.showData();
		ph2.showData();
	}

}