package scm;

// 상품 객체들의 상위클래스
public class Product {

	int price; // 제품의 가격
	int bonusPoint; // 제품의 포인트
	
	Product(int price){
		this.price = price;
		this.bonusPoint = this.price/10;
		
	}
	
}
