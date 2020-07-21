package lms.dao;

public class ResurveDao6 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao6 () {
		
	}
	
	private static ResurveDao6 dao = new ResurveDao6();
	
	public static ResurveDao6 getInstance() {
		return dao;
	}
	
	
	
}
