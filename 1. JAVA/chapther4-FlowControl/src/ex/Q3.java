package ex;

public class Q3 {

	public static void main(String[] args) {

//Q3. 조건연산자(3항 연산자)를 사용하지 않고, if~else를 사용하는 형태로 변경해 보자.		
		
		// num1, num2 변수에 각각의 수를 받는다.
		int num1 = 50, num2 = 100;
		// 큰 수는 big, 차이는 diff라고 변수를 설정한다.
		int big, diff;
		// if문에 조건 num2가 num1보다 클 때 num2가 big(큰 수)라고 선언한다.
		if (num1 < num2) {
			big = num2;
			System.out.println("큰수는 " + big + " 입니다");
			// num2가 num1보다 크지 않으면 num1이 big(큰 수)라고 선언한다.
		} else {
			big = num1;
			System.out.println("큰수는 " + big + " 입니다");
		}
		// if문에 조건 num2가 num1보다 클 때 큰수에서 작은수를 빼준다.
		if (num1 < num2) {
			diff = num2 - num1;
			System.out.println("두수의 차이는 " + diff + " 입니다");
			// num2가 num1보다 크지 않으면 num1에서 num2를 빼준다.
		} else {
			diff = num1 - num2;
			System.out.println("두수의 차이는 " + diff + " 입니다");
		}
	}
}