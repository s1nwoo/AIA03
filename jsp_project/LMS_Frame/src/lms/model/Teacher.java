package lms.model;


//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
public class Teacher {

	private int tIdx;
	private String pw;
	private String name;
	private String tel;
	private String email;
	private String major;
	private String job;

	
	public Teacher() {}

	public Teacher(int tIdx, String pw) {
		this.tIdx = tIdx;
		this.pw = pw;
	}
	
	public Teacher(int tIdx, String pw, String name, String tel, String email, String major, String job) {
		this.tIdx = tIdx;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.major = major;
		this.job = job;
	}


	public int gettIdx() {
		return tIdx;
	}


	public void settIdx(int tIdx) {
		this.tIdx = tIdx;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMajor() {
		return major;
	}


	public void setMajor(String major) {
		this.major = major;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	@Override
	public String toString() {
		return "Teacher [tIdx=" + tIdx + ", pw=" + pw + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", major=" + major + ", job=" + job + "]";
	}

	

	
	
}
