package lms.dao;

public class ResurveDao9 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao9 () {
		
	}
	
	private static ResurveDao9 dao = new ResurveDao9();
	
	public static ResurveDao9 getInstance() {
		return dao;
	}
	
	
	
}
