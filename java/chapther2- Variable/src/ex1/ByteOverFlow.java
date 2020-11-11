package ex1;

public class ByteOverFlow {

	public static void main(String[] args) {

		byte b = 0; // byte형 변수 b 선언 후 0으로 초기화
		int i = 0; // int형 변수 i 선언 후 0으로 초기화
		
		// for문을 이용하여 b 값을 1씩 증가시킨다
		for(int x = 0; x <= 270; x++) {
			System.out.print(b++); //print는 출력 후 줄 바꿈을 하지 않음
			System.out.println('\t'); //tap 출력
			System.out.println("int값" + i++);
		}
		
	}

}
