package phoneversion06;

public class PhoneGameInfo extends PhoneInfo {
	
	String gameName;
	String nickName;
	
	public PhoneGameInfo(String name, String phoneNumber, String address, String email, String gameName, String nickName) {
		super(name, phoneNumber, address, email);
		this.gameName=gameName;
		this.nickName=nickName;
	
	}

	@Override
	public void ShowData() {
		showBasicInfo();
		System.out.println("게임명 : "+gameName);
		System.out.println("닉네임 : "+nickName);
	
	}

	
	
}
