package ex;

public class Q13 {

	public static void main(String[] args) {

//Q13.  구구단의 짝수 단(2,4,8)만 출력하는 프로그램 작성.
//		단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
		
		for (int i = 2; i <= 8; i*=2) {
			System.out.println(i + "단");
			for (int j = 1; j <= 9; j++) {
			if((i%2 == 0)&&(j<=i)) {
			System.out.println(+ i + " x " + j + " = " + i*j);
			}
			}
		}
	}
}