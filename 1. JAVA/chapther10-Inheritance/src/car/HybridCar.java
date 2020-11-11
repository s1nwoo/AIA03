package car;

public class HybridCar extends Car {

	// 전기차 가솔린게이지 변수 설정
	int electronicGauge;

	// 초기화
	HybridCar(int gasolinegauge, int electronicGauge){
	// spuer 메서드 통해서 조상클래스 생성
		super(gasolinegauge);
		
		this.electronicGauge=electronicGauge;
	}
	
	
	
}
