package ex;

public class Singleton {

	// 1. 생성자의 접급제어지시자 : private -> 인스턴스 생성불가
	private Singleton() {}
	
	// 2. 공유할 객체들 생성
	private static Singleton s = new Singleton();
	
	// 3. 참조값을 반환하는 메서드를 생성
	public static Singleton getInstance() {
		return s;
	}
	
	public void print() {
		System.out.println("Singleton");
	}
	
}
