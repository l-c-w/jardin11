package com.jardin.shop11.Controller;

import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jardin.shop11.Dto.MemberDto;
import com.jardin.shop11.Service.MemberService;

@Controller
public class MemberController {

	@Inject
	MemberService memberService;

	// 메인페이지 이동
	@RequestMapping("main")
	public String main() {
		return "main/main";
	}

	// 글 리스트
	@RequestMapping("list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", memberService.list());

		return "list";
	}

	// 회원가입 페이지 이동
	@RequestMapping("join_page")
	public String go_join() throws Exception {
		return "member/join_page";
	}

	// 회원가입
	@PostMapping("join")
	public String join(@ModelAttribute MemberDto memberDto, Model model) throws Exception {
		int check = memberService.join(memberDto);
		model.addAttribute("join_check", check);
		return "member/join_ok";
	}

	// 아이디 중복확인 창
	@RequestMapping("id_check")
	public String id_check() {
		return "member/id_check";
	}

	// 아이디 중복체크
	@RequestMapping("checking")
	@ResponseBody
	public int checking(@RequestBody HashMap<String, Object> map) throws Exception {

		return memberService.checking(map);
	}

	// 로그인 페이지 이동
	@RequestMapping("login_page")
	public String login_page() {
		return "login/login_page";
	}

	// 로그인
	@PostMapping("login")
	@ResponseBody
	public int login(MemberDto memberDto, HttpSession session, Model model) throws Exception {
		int log_check = memberService.login(memberDto, session);
		return log_check;
	}

	// 로그아웃
	@RequestMapping("logout")
	@ResponseBody
	public void logout(HttpSession session, Model model) {
		session.invalidate();
	}

}
