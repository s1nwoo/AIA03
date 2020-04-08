/*
 * 파일이름: FirstJava
 * 작성자: 정신우
 * 작성일: 2020년 4월 08일
 * 작성이유: System.out.println 메소드 기능 테스트
 */
package chapter1;

public class FirstJava {

	public static void main(String[] args) {
	
		// "Hello JAVA! 를 출력하세요.	
		System.out.println("Hello JAVA!");
			
		// 문제 1.
		System.out.println("2+5=" + 2+5);
		System.out.println("2+5=" + (2+5));
		
		// 문제 2.
		System.out.println(15);
		System.out.println("5+10=" + 15);
		System.out.println(5+10);
		System.out.println("5+10" + "의 연산결과는 15입니다.");
		System.out.println("5+10=" + 1+5);
	}

}
