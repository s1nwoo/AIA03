package ex1;

public class CastingOperation {

	public static void main(String[] args) {

		/* 문제
		 * 대문자 'A'의 유니코드값과 'Z'의 유니코드값을 구하시오.
		 */
		 		
		char ch1 = 'A'; // 문자타입의 변수 ch1 선언, 초기화('A' 저장)
		char ch2 = 'Z'; // 문자타입의 변수 ch2 선언, 초기화('Z' 저장)
		
		int num1 = ch1; // 유니코드값을 정수형으로 변환
		int num2 = (int)ch2; // 명시적 형 변환
			
		System.out.println("문자 A의 유니코드 값: "+num1);
		System.out.println("문자 Z의 유니코드 값: "+num2);
		
	}

}
