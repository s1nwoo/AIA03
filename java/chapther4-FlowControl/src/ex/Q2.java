package ex;

public class Q2 {

	public static void main(String[] args) {

//Q2. 다음과 같이 출력이 이루어지도록 작성해보자.
//num < 0 이라면 “0 미만” 출력
//0 ≤ num <100 이라면 “0이상 100 미만“ 출력
//100 ≤ num < 200 이라면 “100이상 200 미만“ 출력
//200 ≤ num < 300 이라면 “200이상 300 미만“ 출력
//300 ≤ num 이라면 “300이상 “ 출력

		// num 변수에 임의의 수를 설정한다.
		int num = 150;
		// if문 조건에 num이 0보다 작을 시 "0 미만" 출력하기.
		if (num < 0) {
			System.out.println("0 미만");
		} else if (0 <= num && num < 100) {
			System.out.println("0이상 100 미만");
		} else if (100 <= num && num < 200)
			System.out.println("100이상 200미만");
		else if (200 <= num && num < 300) {
			System.out.println("200이상 300미만");
		} else {
			System.out.println("300이상");
		}
	}
}
