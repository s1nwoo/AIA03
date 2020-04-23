package ex;

public class Q1 {

	public static void main(String[] args) {

//Q1. 두 개의 정수를 전달받아서, 두수의 사칙연산 결과를 출력하는 메서드와 이 메서드를 호출하는 main메서드를 정의해보자.
//    단, 나눗셈은 몫과 나머지를 각각 출력해야 한다.		
		
		
	// value 메서드에 a값과 b값을 전달한다.
		value(20,10);	
	}
	
	// 두 수의 사칙연산 결과를 출력하는 메서드 선언
		static void value(int a, int b) {
			int add = a + b;
			int min = a - b;
			int mul = a * b;
			int div = a / b;
			int rem = a % b;;
			
			System.out.println(a+" + "+b+" = " +add);
			System.out.println(a+" - "+b+" = " +min);
			System.out.println(a+" * "+b+" = " +mul);
			System.out.println(a+" / "+b+" = "+"몫: " +div+" 나머지: "+rem);
			
		}
		
	}

