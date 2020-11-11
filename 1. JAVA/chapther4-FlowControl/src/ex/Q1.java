package ex;

public class Q1 {

	public static void main(String[] args) {

//Q1. 아래 예제는 두 개의 if문을 사용하고 있다. 
//한 개의 if 문만 사용하는 방식으로 변경해보자.
//int num=120;
//if(num>0) {
//if((num%2)==0)
//System.out.println(“양수이면서 짝수");

		// num 변수에 120을 설정한다.
		int num = 120;
		// if문 조건식에 논리연산자(&&)를 통해 두 조건 모두 true 일때 실행되는 문을 선언한다.
		if (num > 0 && (num % 2) == 0) {
			System.out.println(num + "은 양수이면서 짝수입니다. ");
		}
	}
}
