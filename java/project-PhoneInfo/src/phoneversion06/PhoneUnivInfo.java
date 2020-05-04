package phoneversion06;

public class PhoneUnivInfo extends PhoneInfo {

	String major;
	String grade;
	
	public PhoneUnivInfo(String name, String phoneNumber, String address, String email, String major, String grade) {
		
		super(name, phoneNumber, address, email);
		this.major=major;
		this.grade=grade;
		
	}
	
	
	// 오버라이딩
	@Override
	public void ShowData() {
		showBasicInfo();
		System.out.println("전공: "+major);
		System.out.println("학년: "+grade);
	}

}
