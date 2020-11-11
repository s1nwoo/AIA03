package ex;

public class CondOp {

	public static void main(String[] args) {

		// 숫자 두개를 받는다.
		int num1 = 100, num2 = 50;
		
		// 큰수, 차이 값을 저장하는 변수
		int bigNum, diffNum;
		
		// 큰수 구하기
		bigNum = (num1 > num2) ? num1 : num2;
		// (true) -> big = num1, (false) -> big = num2  
	
		// 두 수의 차이
		diffNum = (num1 > num2) ? num1 - num2 : num2 - num1;
		// (true) -> diffNum = num1 - num2, (false) -> diffNum = num2 - num1
		
		System.out.println("큰수 : " +bigNum);
		System.out.println("두 수의 차이 : " +diffNum);
		
	}
	
}
