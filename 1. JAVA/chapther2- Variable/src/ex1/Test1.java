package ex1;

public class Test1 {

	public static void main(String[] args) {
		/*
		  문제 1.
		  다음 두 문장을 출력하는 프로그램을 작성해 보자.
		 System.out.println( “2+5=” + 2+5 ); 
		 System.out.println( “2+5=” + (2+5) );		 
		 */

		System.out.println("2+5=" + 2+5); // 왼쪽부터 순서대로 연산하여 "문자열" -> "2" -> "5" = 문자열로 변경함
		System.out.println("2+5=" + (2+5)); // 괄호 먼저 연산한 뒤 "문자열" 출력 
	}

}
