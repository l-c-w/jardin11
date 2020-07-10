package com.jardin.shop11.Controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.MemberDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;
import com.jardin.shop11.Service.BoardService;

@Controller
public class BoardContoller {

	@Inject
	BoardService boardService;

	// 메인페이지 이동
	@RequestMapping("main")
	public String main() {
		return "main/main";
	}

	// 글 리스트
	@RequestMapping("list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", boardService.list());

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
		int check = boardService.join(memberDto);
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
		String id = (String) map.get("id");
		return boardService.checking(id);
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
		int log_check = boardService.login(memberDto, session);
		return log_check;
	}

	// 로그아웃
	@RequestMapping("logout")
	@ResponseBody
	public void logout(HttpSession session, Model model) {
		session.invalidate();
	}

	// 이벤트 작성페이지 이동
	@RequestMapping("ewrite_page")
	public String ewrite_page() {
		return "event/event_write";
	}

	// 이벤트 작성
	@PostMapping("event_write")
	public String event_write(MultipartHttpServletRequest request, EventDto eventDto, Model model) throws Exception {
		int write_check = boardService.event_write(eventDto, request);
		model.addAttribute("write_check", write_check);
		return "redirect:event/event";
	}

	// 이벤트 페이지(진행,종료)
	@RequestMapping("event")
	public String event(HttpServletRequest request, SearchingDto searchingDto, Model model) throws Exception {
		String event_type = request.getParameter("event_type");
		String return_path = null;
		PagingDto pagingDto = boardService.e_paging(searchingDto, event_type);
		List<EventDto> list = boardService.event(searchingDto, event_type);

		model.addAttribute("paging", pagingDto);
		model.addAttribute("list", list);
		model.addAttribute("sv", searchingDto);

		if (event_type == null || event_type.equals("event")) {
			return_path = "event/event";
		} else if (event_type.equals("fin_event")) {
			return_path = "event/fin_event";
		}

		return return_path;
	}

	// 이벤트 상세
	@RequestMapping("event_view")
	public String event_view(PagingDto pagingDto, HttpServletRequest request, Model model) throws Exception {
		pagingDto = boardService.r_paging(pagingDto, request);
		pagingDto.setEvent_type(request.getParameter("event_type"));

		model.addAttribute("r_paging", pagingDto);
		model.addAttribute("reply_list", boardService.reply_list(request, pagingDto));
		model.addAttribute("event_view", boardService.event_view(request));
		model.addAttribute("reply_count", boardService.reply_count(request));
		return "event/event_view";
	}

	// 리플 작성
	@RequestMapping("reply")
	@ResponseBody
	public void reply(HttpSession session, ReplyDto replyDto, Model model) throws Exception {
		model.addAttribute("insert_ch", boardService.reply(replyDto, session));
		model.addAttribute("reply", replyDto);
	}

	// 리플 수정
	@PostMapping("r_update")
	@ResponseBody
	public int r_update(ReplyDto replyDto, Model model) throws Exception {
		return boardService.r_update(replyDto);
	}

	// 리플 삭제 새창
	@RequestMapping("password")
	public String password(HttpServletRequest request, Model model) {
		model.addAttribute("r_number", request.getParameter("r_number"));
		return "event/password";
	}

	// 리플 삭제
	@RequestMapping("r_del")
	@ResponseBody
	public int r_del(@RequestBody HashMap<String, Object> map, Model model) throws Exception {
		return boardService.r_del(map);
	}

}
