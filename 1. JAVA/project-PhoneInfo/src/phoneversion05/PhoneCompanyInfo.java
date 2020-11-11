package phoneversion05;

public class PhoneCompanyInfo extends PhoneInfo {

	String company;
	String dept;
	String job;
	
	public PhoneCompanyInfo(String name, String phoneNumber, String address, String email, String company, String dept, String job) {
		super(name, phoneNumber, address, email);
		this.company=company;
		this.dept=dept;
		this.job=job;
		
	}

	@Override
	public void ShowData() {
		showBasicInfo();
		System.out.println("회사: "+company);
		System.out.println("부서: "+dept);
		System.out.println("직무: "+job);
		
	}
	

}
