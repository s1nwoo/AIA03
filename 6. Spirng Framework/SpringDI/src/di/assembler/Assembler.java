package di.assembler;

import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;

public class Assembler {
	
	// 조립기는 객체를 보관한다.
	private MemberDao memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		// 	조립기는 객체를 생성한다.
		memberDao = new MemberDao();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService(memberDao);
	}

	// 조립기는 객체를 제공한다.
	public MemberDao getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}
