package com.jardin.shop11.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.MemberDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;

public interface BoardService {

	// 글 리스트 가져오기
	public List<BoardDto> list() throws Exception;

	// 회원가입
	public int join(MemberDto memberDto);

	// 아이디 체크
	public int checking(String id) throws Exception;

	// 로그인
	public int login(MemberDto memberDto, HttpSession session) throws Exception;

	// 이벤트 등록
	public int event_write(EventDto eventDto, MultipartHttpServletRequest request) throws Exception;

	// 이벤트 페이징
	public PagingDto e_paging(SearchingDto searchingDto, String event_type) throws Exception;

	// 이벤트 목록
	public List<EventDto> event(SearchingDto searchingDto, String event_type) throws Exception;

	// 종료이벤트 목록
	public List<EventDto> fin_event() throws Exception;

	// 이벤트 보기
	public EventDto event_view(HttpServletRequest request) throws Exception;

	// 리플 리스트 페이징
	public PagingDto r_paging(PagingDto pagingDto, HttpServletRequest request) throws Exception;

	// 리플 리스트
	public List<ReplyDto> reply_list(HttpServletRequest request, PagingDto pagingDto) throws Exception;

	// 리플 갯수
	public int reply_count(HttpServletRequest request) throws Exception;

	// 리플 작성
	public int reply(ReplyDto replyDto, HttpSession session) throws Exception;

	// 리플 수정
	public int r_update(ReplyDto replyDto) throws Exception;

	// 리플 삭제
	public int r_del(HashMap<String, Object> map) throws Exception;

}
