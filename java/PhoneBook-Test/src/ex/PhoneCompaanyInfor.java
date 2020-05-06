package ex;

public class PhoneCompaanyInfor extends PhoneInfor{

	String company;
	
	public PhoneCompaanyInfor(String name, String phoneNumber, String email, String company) {
		super(name, phoneNumber, email);
		this.company=company;
	}

	@Override
	public void showBasicData() {
		showBasicData();
		System.out.println("회사 :" +company);
	}
	
	
	
	
}
