package ex;

public class PhoneGame {

	private String fr_g_gamename;
	private String fr_g_nickname;
	
	public PhoneGame() {
		
	}
	
	public PhoneGame(String fr_g_gamename, String fr_g_nickname) {
		this.fr_g_gamename = fr_g_gamename;
		this.fr_g_nickname = fr_g_nickname;
	}

	public String getFr_g_gamename() {
		return fr_g_gamename;
	}

	public void setFr_g_gamename(String fr_g_gamename) {
		this.fr_g_gamename = fr_g_gamename;
	}

	public String getFr_g_nickname() {
		return fr_g_nickname;
	}

	public void setFr_g_nickname(String fr_g_nickname) {
		this.fr_g_nickname = fr_g_nickname;
	}

	@Override
	public String toString() {
		return "PhoneGame [fr_g_gamename=" + fr_g_gamename + ", fr_g_nickname=" + fr_g_nickname+"]";
	}
	
	
	
}
