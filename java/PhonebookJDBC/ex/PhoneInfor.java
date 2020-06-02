package ex;

public class PhoneInfor {

	private int idx;
	private String name;
	private String phonenumber;
	private String email;
	private String address;
	private String category;
	private String major;
	private String grade;	
	private String company;	
	private String dept;
	private String job;
	private String gamename;
	private String nickname;
	
	public PhoneInfor() {
		
	}
	
	public PhoneInfor(int idx, String name, String phonenumber, String email, String address, String category, String major, String grade, String company, String dept, String job, String gamename, String nickname) {
		this.idx = idx;
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.category = category;
		this.major = major;
		this.grade = grade;
		this.company = company;
		this.dept = dept;
		this.job = job;
		this.gamename = gamename;
		this.nickname = nickname;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGamename() {
		return gamename;
	}

	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
