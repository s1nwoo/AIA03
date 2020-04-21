package membership;

public class MemberShipMain {

	public static void main(String[] args) {

		// 회원 정보 5개를 저장할 수 있는 배열을 생성
		// Member 타입의 인스턴스의 참조값을 저장하는 메모리 공간
		// Member m1, m2, m3, m4 ,m5
		Member[] members = new Member[5];
		
		//Member 타입의 인스턴스 주소 저장
		members[0] = new Member("wjd", "정", "wjd@naver.com"); 
		members[1] = new Member("tls", "신", "tls@naver.com");
		members[2] = new Member("dn", "우", "dn@naver.com");
		members[3] = new Member("kevin de bruyne", "덕배", "mancity1@naver.com");
		members[4] = new Member("guardiola", "펩", "mancity2@naver.com");

		for(int i=0; i<members.length;i++) {
			System.out.println(members[i]);
		}
		
		System.out.println("=================");
		
		for(int i=0; i<members.length;i++) {
			members[i].showInfo();
			System.out.println("-----------------");
		}

		
		
//		members[0].showInfo();
//		members[1].showInfo();		
//		members[2].showInfo();
//		members[3].showInfo();
//		members[4].showInfo();
		
//		Member member = new Member("wjd", "정", "wjd@naver.com");
//		member.showInfo();
//		System.out.println("---------");
//		System.out.println(member);
		
	}

}
