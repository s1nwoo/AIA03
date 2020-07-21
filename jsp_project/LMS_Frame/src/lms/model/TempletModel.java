package lms.model;


// Model 클래스 이용에 대한 예제입니다.
public class TempletModel {

	private String a;
	private String b;
	
	// 로직을 가지고 있지 않은 순수한 데이터 객체로 만들어줍니다.
	// 속성과 그 속성에 접근하기 위한 getter/setter 메소드만을 가진 클래스입니다.
	public TempletModel(String a, String b) {
	
		this.a = a;
		this.b = b;
	}
	
	public TempletModel () {
		
	}


	public String getA() {
		return a;
	}


	public void setA(String a) {
		this.a = a;
	}


	public String getB() {
		return b;
	}


	public void setB(String b) {
		this.b = b;
	}
	
	
	
	
}
