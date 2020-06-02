package ex;

public class PhoneCom {

	private String fr_c_company;
	
	public PhoneCom() {
		
	}
	
	public PhoneCom(String company) {
		this.fr_c_company = company;
	}

	public String getCompany() {
		return fr_c_company;
	}

	public void setCompany(String company) {
		this.fr_c_company = company;
	}

	@Override
	public String toString() {
		return "PhoneCom [company=" + fr_c_company + "]";
	}
	
	
	
}
