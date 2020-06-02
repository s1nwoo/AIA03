package ex;

public class PhoneBasic {

	private int idx;
	private String fr_name;
	private String fr_phonenum;
	private String fr_email;
	private String fr_address;
	
	public PhoneBasic() {
		
	}
	
	public void PhoneBasic(int idx, String fr_name, String fr_phonenum
			, String fr_email, String fr_address) {
		this.idx = idx;
		this.fr_name = fr_name;
		this.fr_phonenum = fr_phonenum;
		this.fr_email = fr_email;
		this.fr_address = fr_address;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getFr_name() {
		return fr_name;
	}

	public void setFr_name(String fr_name) {
		this.fr_name = fr_name;
	}

	public String getFr_phonenum() {
		return fr_phonenum;
	}

	public void setFr_phonenum(String fr_phonenum) {
		this.fr_phonenum = fr_phonenum;
	}

	public String getFr_email() {
		return fr_email;
	}

	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}

	public String getFr_address() {
		return fr_address;
	}

	public void setFr_address(String fr_address) {
		this.fr_address = fr_address;
	}

	@Override
	public String toString() {
		return "PhoneBasic [idx=" + idx + ", fr_name=" + fr_name+ ", fr_phonenum" + fr_phonenum + 
				", fr_email" + fr_email + "fr_address" + fr_address+"]";
	}
	
	
	
}
