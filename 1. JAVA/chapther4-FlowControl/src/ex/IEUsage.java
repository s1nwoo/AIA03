package ex;

public class IEUsage {

	public static void main(String[] args) {

		int num = 10;
		
		// 양수 판별 : 양수 일때 "양수입니다"
		if (num > 0) {
			System.out.println("양수입니다");
		}
		
		// 홀/짝수 판별
		if (num % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
		
	}

}
