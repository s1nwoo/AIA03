package kr.co.dao;

import kr.co.vo.MemberVO;

public interface MemeberDAO {
	
	// 회원가입
	public void register(MemberVO vo) throws Exception;
}
