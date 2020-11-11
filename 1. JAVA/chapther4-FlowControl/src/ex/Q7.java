package ex;

public class Q7 {

	public static void main(String[] args) {

//Q7. 1부터 100까지 출력한 후, 다시 거꾸로 100부터 1까지 출력하는 프로그램을 작성. 
//    while문과 do~while 문을 각각 한번씩 사용해서 작성		
		
		int i = 0;
		System.out.println("1부터 100까지 숫자를 출력합니다");
		while(i<100) {
			i++;
			System.out.println(i);
		} 
		System.out.println("---------------------");
		System.out.println("100부터 1까지 숫자를 출력합니다");
		
		int j = 100;
		do {
			System.out.println(j);
			j--;
			} while(j>0);
		}
	}

