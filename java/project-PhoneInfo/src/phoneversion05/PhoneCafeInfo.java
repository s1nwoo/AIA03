package phoneversion05;

public class PhoneCafeInfo extends PhoneInfo {
	
	String cafeName;
	String nickName;
	
	public PhoneCafeInfo(String name, String phoneNumber, String address, String email, String cafeName, String nickName) {
		super(name, phoneNumber, address, email);
		this.cafeName=cafeName;
		this.nickName=nickName;
	
	}

	@Override
	public void ShowData() {
		super.ShowData();
		System.out.println("동호회명 :"+cafeName);
		System.out.println("닉네임 : "+nickName);
	
	}

	
	
}
