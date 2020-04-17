package api;

public class StringTest {

	public static void main(String[] args) {

		
		
		String str1 = "My String";
		String str2 = "My String";
		String str3 = "Your String";

		System.out.println(str1==str2);	
		System.out.println(str1==str3);
		
		
		System.out.println("--------------------------");
		
		java.lang.String str = "My name is JAVA";
		
		int strLenght = str.length();
		System.out.println("문자열 str의 문자열 길이는 "+strLenght+"개 입니다.");

		int strLenght2 = "한글의 길이는?".length();
		System.out.println("문자열 str의 문자열 길이는 "+strLenght2+"개 입니다.");
		
		
		
		
		
		
	}

}
