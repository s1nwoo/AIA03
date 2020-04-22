package ex;

public class Q1 {

//Q1. 다음 형태로 String 인스턴스를 생성.
//	  String str = “ABCDEFGHIJKLMN”;
//    그리고 이 문자열을 역순으로 다시 출력하는 프로그램을 작성.
	
	public static void main(String[] args) {

		// 문자열 str 변수에 "ABCDEFGHIJKLMN" 입력
		String str = "ABCDEFGHIJKLMN";
		
		// 배열의 길이 -1 만큼해야 가장 끝에서 시작
		for (int i = str.length()-1; i>=0; i--){
			
			// 맨 끝에서 0번까지 출력
            System.out.print(str.charAt(i));
		
		}
	}
}
