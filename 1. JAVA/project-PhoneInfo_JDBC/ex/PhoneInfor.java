package ex;

public class PhoneInfor {

	private int pidx;
	private String name;
	private String phonenumber;
	private String address;
	private String email;
	private String category;
	private String major;
	private String grade;	
	private String company;	
	private String dept;
	private String job;
	private String cafename;
	private String nickname;
	
	public PhoneInfor() {
		
	}
	
	public PhoneInfor(String name, String phonenumber, String address, String email, String category, String major, String grade, String company, String dept, String job, String cafename, String nickname) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.email = email;
		this.category = category;
		this.major = major;
		this.grade = grade;
		this.company = company;
		this.dept = dept;
		this.job = job;
		this.cafename = cafename;
		this.nickname = nickname;
	}

	public int getPidx() {
		return pidx;
	}

	public void setPidx(int pidx) {
		this.pidx = pidx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCafename() {
		return cafename;
	}

	public void setCafename(String cafename) {
		this.cafename = cafename;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	
	
}
