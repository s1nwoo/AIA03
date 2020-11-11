package ex;

public class Q16 {

	public static void main(String[] args) {

//Q16. 1 부터 99까지의 합을 구하는 프로그램 작성
//		while문, for문, do while 문을 각각 사용

		int i = 0, sum = 0;
		
		//while문
		while(i<100) {
			sum+=i; 
			i++;
			System.out.println(sum);
		}
		
		//for문
		for(i=1; i<100; i++) {
			sum+=i;
			System.out.println(sum);
		}
		
		//do while 문
		do {
			i+=1;
			sum+=i;
		}while(i<99);
		System.out.println(sum);
		
		}
	}
