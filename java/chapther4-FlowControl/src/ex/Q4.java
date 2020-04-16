package ex;

public class Q4 {

	public static void main(String[] args) {

//Q4. switch문이 아닌, if~else를 사용하는 형태로 변경해 보자.
		
//	int n=3;
//		switch(n) {
//		case 1:
//		System.out.println("Simple Java");
//		break;
//		case 2:
//		System.out.println("Funny Java");
//		break;
//		case 3:
//		System.out.println("Fantastic Java");
//		break;
//		default:
//		System.out.println("The best programming language");
//		}
//		System.out.println("Do you like coffee?");
		int n = 3;
		if(n == 3) {
		System.out.println("Fantastic Java");
		} else if(n == 1) {
		System.out.println("Simple JAVA");	
		} else if(n == 2) {
		System.out.println("Funny JAVA");
		} else {
			System.out.println("The best programing language");
		}
		System.out.println("Do you like coffee?");
	}

}
