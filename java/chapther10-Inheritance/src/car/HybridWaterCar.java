package car;

public class HybridWaterCar extends HybridCar {

	// 가솔린, 전기, 물 모두 사용하는 차량 가솔린게이지 선언
	int waterGauge;
	
	// 초기화
	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGauge){
	// super 메서드를 통해 조상클래스 호출
		super(gasolinegauge, electronicGauge);
		this.waterGauge=waterGauge;
	}
	
	// 출력메서드 선언
	public void showCurrentGauge() {
	System.out.println("잔여 가솔린 : " + gasolinegauge);
	System.out.println("잔여 가솔린 : " + electronicGauge);
	System.out.println("잔여 가솔린 : " + waterGauge);
	}
	
}
