package ex;

public class AccessWayMain {

	public static void main(String[] args) {

		
		// 클래스 변수 호출
		System.out.println(AccessWay.num);
		AccessWay.num++;
		System.out.println(AccessWay.num);
		
		
		// 인스턴스 변수 호출
		AccessWay ac = new AccessWay();	
		System.out.println(ac.num2);
		
	}

}
