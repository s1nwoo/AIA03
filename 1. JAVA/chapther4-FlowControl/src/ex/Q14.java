package ex;

public class Q14 {

	public static void main(String[] args) {

//Q14. 다음 식을 만족하는 조합을 찾는 프로그램 작성. 
//		A B
//		B A
//		------
//		9 9		

		int A = 0, B = 0;
		for(A=0; A<=9; A++) {
			B = 9-A;
			System.out.println("A가 "+A+"일때 B는 "+B);
		}
	}
}
