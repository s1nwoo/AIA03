package lms.dao;

public class ResurveDao1 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao1 () {
		
	}
	
	private static ResurveDao1 dao = new ResurveDao1();
	
	public static ResurveDao1 getInstance() {
		return dao;
	}
	
	
	
}
