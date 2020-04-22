package ex;

public class Q4 {

//Q4. 전달되는 값이 소수(prime number)인지 아닌지를 판단하여, 소수인경우 true를, 소수가 아닌 경우 false를 반환하는 메서드를 정의하고, 
//	    이를 이용해서 1이상 100 이하의 소수를 전부 출력할 수 있도록 main 메서드를 정의하자.

	public static void main(String[] args) {
		  for(int k = 1; k<=100; k++) {
		   if(prime(k)) {
		    System.out.println(k);
		   }
		  }
		 }

		 static boolean prime(int a) {
		  boolean result = true;
		  if(a <= 1) {
		   result = false;
		  }
		  for(int i = a-1; i >1; i-- ) {
		   if(a%i == 0) {
		    result = false;
		    break;
		   }
		  }
		  return result;
		 }
}
