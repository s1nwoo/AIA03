package ex;

public class Q6 {

	public static void main(String[] args) {

//Q6. while 문을 이용해서 1부터 99까지의 합을 구하는 프로그램을 작성하세요.
		
		int i = 1;
		int sum = 0;
		
		while (i < 100) {
			System.out.println("i=" + i + "\t");
			System.out.println("[sum=" + sum +"]+"+i+"=");
			sum += i; // sum = sum + i;
			System.out.println(sum);
			i++;
		}
		System.out.println(sum);


	}

}
