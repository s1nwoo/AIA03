package phoneversion01;

public class PhoneInfo {

	String name;
	String phoneNumber;
	String brithday;
	
	public PhoneInfo(String name, String num, String day) {
		this.name = name;
		this.phoneNumber = num;
		this.brithday = day;
	}
	
	public PhoneInfo(String name, String num) {
		this.name = name;
		this.phoneNumber = num;
		this.brithday = "[미입력]";
	}
	
	
	public void showData() {
		System.out.println("이름: " +name+"\n번호: "+phoneNumber+"\n생일: "+brithday);
		System.out.println("-------------------");
	}
	
	public static void main(String[] args) {
		
		PhoneInfo ph1 = new PhoneInfo("정신우", "010-xxxx-7317", "920928");
		PhoneInfo ph2 = new PhoneInfo("홍길동", "010-xxxx-4444");
		ph1.showData();
		ph2.showData();
	}

}