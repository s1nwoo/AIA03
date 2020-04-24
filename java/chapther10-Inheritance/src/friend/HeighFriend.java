package friend;

public class HeighFriend extends Friend {

	String work; // 친구의 직업
	
	public HeighFriend(String name, String phoneNum, String addr, String job) {
	
		super(name, phoneNum, addr);
		this.work = job;
		
	}

	@Override
	public void showData() {
		showBasicInfo();
		System.out.println("직업: " +work);
	}
	
}
