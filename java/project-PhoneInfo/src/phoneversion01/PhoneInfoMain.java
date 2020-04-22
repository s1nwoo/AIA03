package phoneversion01;

public class PhoneInfoMain {

	public static void main(String[] args) {
		
		PhoneInfo ph = new PhoneInfo("정신우", "010-xxxx-7317", "920928");
		ph.showData();
		ph = new PhoneInfo("홍길동", "010-xxxx-4444");
		ph.showData();
		
		
	}

}
