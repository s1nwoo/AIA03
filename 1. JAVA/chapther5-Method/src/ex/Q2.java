package ex;

public class Q2 {

//Q2 . 두 개의 정수를 전달 받아서, 두수의 절대값을 계산하여 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해 보자. 
//	      단, 메서드 호출 시 전달되는 값의 순서에 상관없이 절대값이 계산되어서 출력되어야 한다.

	static void abs(int a, int b) {
		System.out.println("a의 절대값: "+Math.abs(a));
		System.out.println("b의 절대값: "+Math.abs(b));
	}
	
	public static void main(String[] args) {
	
		abs(10,20);
		
	}
	
}

