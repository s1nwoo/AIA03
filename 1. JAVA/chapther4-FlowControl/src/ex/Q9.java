package ex;

public class Q9 {

	public static void main(String[] args) {

//Q9. for문을 이용하여 1부터 10까지를 곱해서 그 결과를 출력하는 프로그램을 작성	
		
	int sum = 1;
	for(int i=1; i<11; i++) {
		sum*=i;
	}
	System.out.println("1부터 10까지의 곱의 결과는 "+sum+"입니다.");
		
	}

}
