package lms.dao;

public class ResurveDao5 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao5 () {
		
	}
	
	private static ResurveDao5 dao = new ResurveDao5();
	
	public static ResurveDao5 getInstance() {
		return dao;
	}
	
	
	
}
