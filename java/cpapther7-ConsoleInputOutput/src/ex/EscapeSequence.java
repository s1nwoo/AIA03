package ex;

public class EscapeSequence {

	public static void main(String[] args) {

		
		//%d = 10진수 정수 형태
		//%s = 문자열 출력
		//%f = 실수 출력
		int age = 29;
		double tall = 178.4;
		String name = "정신우";
		
		System.out.printf("제 이름은  %s입니다. \n", name);
		System.out.printf("제 나이는 %d이고, 키는 %f 입니다. \n", age, tall);
		
	}

}
