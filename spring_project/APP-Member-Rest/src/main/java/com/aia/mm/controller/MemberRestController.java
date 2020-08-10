package com.aia.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberEditRequest;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberListService;
import com.aia.mm.service.MemberRegService;
import com.aia.mm.service.MemberViewService;

@RestController
@RequestMapping("/members")  //  /members?pageNum=1&cnt=10
public class MemberRestController {
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberRegService regService;
	
	@Autowired
	private MemberViewService viewService;
	
	// 회원의 리스트 : Json 으로 응답
	@GetMapping     // GET | /members
	public List<Member> getMemberList(){
		return listService.getMemberList() ;
	}
	
	// 회원 가입
	@PostMapping	// POST | /members
	public int reg(MemberRegRequest regRequest) {
		
		return regService.regMember(regRequest);
	}
	
	// 한명의 회원의 정보 보기
	@GetMapping("/{idx}")
	public Member getMember(
			@PathVariable("idx") int idx
			) {
		
		return viewService.getMember(idx);
	}
	
	// 한명의 회원 정보 수정
	@PutMapping("/{idx}")   // PUT | /members/{idx}
	public int edit(
			@PathVariable("idx") int idx,
			MemberEditRequest editRequest,
			HttpServletRequest request
			) {
		
		return 0;
	}
	
	// 회원 삭제
	@DeleteMapping("/{idx}")
	public int delete() {
		return 0;
	}
	
	

}






