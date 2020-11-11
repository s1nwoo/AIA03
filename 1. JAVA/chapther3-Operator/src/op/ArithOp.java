package op;

public class ArithOp {

	public static void main(String[] args) {
		// 1. 정수 타입의 숫자 두개를 받는다. -> 변수 선언
		int num1 = 10;
		int num2 = 3;
		
		// 2. 덧셈 연산 -> 결과를 출력한다.
		int result = num1 + num2;
		System.out.println("num1 + num2 = "+ result);
		
		// 3. 빼기 연산 -> 결과를 출력한다.
		result = num1 - num2;
		System.out.println("num1 - num2 = "+ result);
		
		// 4. 곱의 연산 -> 결과를 출력한다.
		result = num1 * num2;
		System.out.println("num1 * num2 = "+ result);

		// 5. 나누기 연산 -> 결과를 출력한다.
		result = num1 / num2;
		System.out.println("num1 / num2 = "+ result);

		// 6. 나머지 연산 -> 결과를 출력한다.
		result = num1 % num2;
		System.out.println("num1 % num2 = "+ result);
		
	}

}
