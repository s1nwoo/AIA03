package com.aia.op.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MypageController {

	@RequestMapping("/member/mypage/mypage")
	public String getMypage() {
		
		return "member/mypage";
	}
}
