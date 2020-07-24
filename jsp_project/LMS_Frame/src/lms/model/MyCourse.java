package lms.model;


//자신이 사용할 Dao/Model/Service resurve 파일 번호를 항상 공유해주세용!
public class MyCourse {
	
	private int sIdx;
	private int cIdx;
	
	
	public MyCourse(int sIdx, int cIdx) {
	
		this.sIdx = sIdx;
		this.cIdx = cIdx;
	}


	public int getsIdx() {
		return sIdx;
	}


	public void setsIdx(int sIdx) {
		this.sIdx = sIdx;
	}


	public int getcIdx() {
		return cIdx;
	}


	public void setcIdx(int cIdx) {
		this.cIdx = cIdx;
	}
	
	

	
	
}
