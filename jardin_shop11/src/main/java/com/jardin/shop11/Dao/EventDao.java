package com.jardin.shop11.Dao;

import java.util.List;

import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;

public interface EventDao {

	// 이벤트 등록
	public int event_write(EventDto eventDto) throws Exception;

	// 이벤트 페이징
	public PagingDto e_paging(SearchingDto searchingDto) throws Exception;

	// 이벤트 목록
	public List<EventDto> event(SearchingDto searchingDto) throws Exception;

	// 종료이벤트 목록
	public List<EventDto> fin_event() throws Exception;

	// 이벤트 보기
	public EventDto event_view(String e_code) throws Exception;

	// 리플 리스트 페이징
	public PagingDto r_paging(PagingDto pagingDto) throws Exception;

	// 리플 리스트
	public List<ReplyDto> reply_list(PagingDto pagingDto) throws Exception;

	// 리플 갯수
	public int reply_count(String e_code) throws Exception;

	// 리플 작성
	public int reply(ReplyDto replyDto) throws Exception;

	// 리플 수정
	public int r_update(ReplyDto replyDto) throws Exception;

	// 리플 입력 비밀번호 체크
	public String r_pw_ch(ReplyDto replyDto) throws Exception;

	// 리플 삭제
	public int r_del(ReplyDto replyDto) throws Exception;
}
