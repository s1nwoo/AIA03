package ex;

public class Q8 {

	public static void main(String[] args) {

//Q.8  1000 이하의 자연수 중에서 2의 배수 이면서 7의 배수인 숫자를 출력하고, 
//	       그 출력된 숫자들의 합을 구하는 프로그램을 while문을 이용해서 작성		

		int num = 1, sum = 0, count = 0;
		
		while(num <= 1000) {
			if(num%2==0 && num%7==0) {
				sum += num;
			}
			num++;
		}
		System.out.println("2의 배수이면서 7의 배수인 숫자들의 합은 "+sum+"입니다.");
	}
}
