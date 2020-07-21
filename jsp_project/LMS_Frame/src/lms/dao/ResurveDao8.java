package lms.dao;

public class ResurveDao8 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao8 () {
		
	}
	
	private static ResurveDao8 dao = new ResurveDao8();
	
	public static ResurveDao8 getInstance() {
		return dao;
	}
	
	
	
}
