package ex;

public class PhoneUnivInfor extends PhoneInfor{

	String major;
	String year;
	
	public PhoneUnivInfor(String name, String phoneNumber, String email, String major, String year) {
		super(name,phoneNumber,email);
		this.major = major;
		this.year = year;
	}

	@Override
	public void showBasicData() {
		showBasicData();
		System.out.println("전공 : "+major);
		System.out.println("학년 : "+year);
	}
	
	
}
