
public class DivideByZero {

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 0;
		
		try {
	
			// 예외 발생 지점
			int divide = num1/num2;
			System.out.println("연산의 결과: "+divide);	
			
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		
		
		
	}

}
