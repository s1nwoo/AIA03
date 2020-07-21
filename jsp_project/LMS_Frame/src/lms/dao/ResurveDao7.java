package lms.dao;

public class ResurveDao7 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao7 () {
		
	}
	
	private static ResurveDao7 dao = new ResurveDao7();
	
	public static ResurveDao7 getInstance() {
		return dao;
	}
	
	
	
}
