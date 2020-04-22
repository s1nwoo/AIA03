package ex;

public class Q2 {

	public static void main(String[] args) {

//Q2. 다음 형태로 주민번호를 담고 있는 String 인스턴스를 하나 생성
//	  String str = “990929-1010123”		
//	    이 문자열을 이용하여 중간에 삽입된 – 를 뺀 String 인스턴스를 생성.
	
		String str1 = "990929-1010123";
		String s2;
		
		// replace 이용하여("-" 삭제, "" 추가)
		s2 = str1.replace("-", "");
		System.out.println(s2);
		
	}

}
