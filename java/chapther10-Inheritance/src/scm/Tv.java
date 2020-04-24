package scm;

// 하위클래스 Tv, 상위클래스 Product
public class Tv extends Product {

	Tv(int price){
		super(price);
	}
	
	public String toString() {
		return "Tv";
	}
	
	void display() {
		System.out.println("화면을 출력합니다.");
	}
	
}
