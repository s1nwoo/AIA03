package ex;

public class PhoneUniv {

	private String fr_u_magor;
	private String fr_u_grade;
	
	public PhoneUniv() {
		
	}
	
	public PhoneUniv(String fr_u_magor, String fr_u_grade) {
		this.fr_u_magor = fr_u_magor;
		this.fr_u_grade = fr_u_grade;
	}

	public String getFr_u_magor() {
		return fr_u_magor;
	}

	public void setFr_u_magor(String fr_u_magor) {
		this.fr_u_magor = fr_u_magor;
	}

	public String getFr_u_grade() {
		return fr_u_grade;
	}

	public void setFr_u_grade(String fr_u_grade) {
		this.fr_u_grade = fr_u_grade;
	}

	@Override
	public String toString() {
		return "PhoneUniv [fr_u_magor=" + fr_u_magor + ", fr_u_grade=" + fr_u_grade+"]";
	}
	
	
	
}
