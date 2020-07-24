package com.jardin.shop11.Controller;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;
import com.jardin.shop11.Service.EventService;

@Controller
public class EventController {

	@Inject
	EventService eventService;

	// 이벤트 작성페이지로 이동
	@RequestMapping("ewrite_page")
	public String ewrite_page() {
		return "event/event_write";
	}

	// 이벤트 작성
	@PostMapping("event_write")
	public String event_write(MultipartHttpServletRequest request, EventDto eventDto, Model model) throws Exception {
		int write_check = eventService.event_write(eventDto, request);
		model.addAttribute("write_check", write_check);
		return "redirect:event";
	}

	// 이벤트 페이지(진행,종료 분기)
	@RequestMapping("event")
	public String event(HttpServletRequest request, SearchingDto searchingDto, Model model) throws Exception {
		// 분기 체크용 이벤트 타입과 분기할 리턴 패스 설정
		String event_type = request.getParameter("event_type");
		String return_path = null;

		// 페이징과 리스트 받아옴
		PagingDto pagingDto = eventService.e_paging(searchingDto, event_type);
		List<EventDto> list = eventService.event(searchingDto, event_type);

		model.addAttribute("paging", pagingDto);
		model.addAttribute("list", list);
		model.addAttribute("sv", searchingDto);

		// 진행,종료 분기
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
		// 이벤트 상세
		model.addAttribute("event_view", eventService.event_view(request));
		// 리플 페이징
		pagingDto = eventService.r_paging(pagingDto, request);
		pagingDto.setEvent_type(request.getParameter("event_type"));
		model.addAttribute("r_paging", pagingDto);
		// 리플 리스트
		model.addAttribute("reply_list", eventService.reply_list(request, pagingDto));
		// 리플 카운트
		model.addAttribute("reply_count", eventService.reply_count(request));
		return "event/event_view";
	}

	// 리플 작성
	@RequestMapping("reply")
	@ResponseBody
	public void reply(HttpSession session, ReplyDto replyDto, Model model) throws Exception {
		// 리플 작성 확인
		model.addAttribute("insert_ch", eventService.reply(replyDto, session));
		model.addAttribute("reply", replyDto);
	}

	// 리플 수정
	@PostMapping("r_update")
	@ResponseBody
	public int r_update(ReplyDto replyDto, Model model) throws Exception {
		return eventService.r_update(replyDto);
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
		return eventService.r_del(map);
	}

}
