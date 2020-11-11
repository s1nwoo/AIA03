package ex;

public class Ex1 {

	public static void main(String[] args) {
		
		// 1~10까지의 합
		// 반복 1+ 씩
		
		// 연산의 합을 담는 변수
		int sum = 0;
		
		for(int i=1; i<=10; i++) {
			sum += i;
		}
		System.out.println("1부터 10까지의 합: " + sum);
		
		
	}

}
