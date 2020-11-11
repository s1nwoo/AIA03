package ex1;

public class CharToCode {

	public static void main(String[] args) {
		
		char ch = 'A'; // 문자타입의 변수 ch 선언, 초기화('A' 저장) = '\u0041';
		int code = (int)ch; // 변수 ch에 저장된 값을  정수형으로 변환하여 저장
		
		System.out.println(ch);
		System.out.println(code);
		
		
	}

}
