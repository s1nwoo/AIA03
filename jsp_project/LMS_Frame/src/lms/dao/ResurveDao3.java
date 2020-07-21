package lms.dao;

public class ResurveDao3 {
	
	// 싱글톤 처리 완료
	// 자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
	private ResurveDao3 () {
		
	}
	
	private static ResurveDao3 dao = new ResurveDao3();
	
	public static ResurveDao3 getInstance() {
		return dao;
	}
	
	
	
}
