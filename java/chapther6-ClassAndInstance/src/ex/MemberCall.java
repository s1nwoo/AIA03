package ex;

public class MemberCall {

	// 인스턴스 변수
	int iv = 10;
	// 클래스(스태틱) 변수
	static int cv = 20;
	
	int iv2 = cv;
	
	//static int cv2 = iv; 출력오류
	static int cv2 = new MemberCall().iv;
	
	static void staticMethod() {
		// 스태틱 멤버 출력
		System.out.println(cv);
		// 인스턴스 멤버 출력
		// System.out.println(iv); 출력오류
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
	}
	
	void instanceMethod() {
		// 스태틱 멤버 출력
		System.out.println(cv);
		// 인스턴스 멤버 출력
		System.out.println(iv);
	}
	
}
