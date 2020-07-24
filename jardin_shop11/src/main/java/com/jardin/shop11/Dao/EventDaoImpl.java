package com.jardin.shop11.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;

@Repository
public class EventDaoImpl implements EventDao {

	@Inject
	SqlSession sqlSession;

	private static String namespace = "com.jardin.shop11.Dao.EventDao";

	// 이벤트 등록
	@Override
	public int event_write(EventDto eventDto) throws Exception {
		return sqlSession.insert(namespace + ".event_write", eventDto);
	}

	// 이벤트 페이징
	@Override
	public PagingDto e_paging(SearchingDto searchingDto) throws Exception {
		return sqlSession.selectOne(namespace + ".event_paging", searchingDto);
	}

	// 이벤트 목록
	@Override
	public List<EventDto> event(SearchingDto searchingDto) throws Exception {
		return sqlSession.selectList(namespace + ".event", searchingDto);
	}

	// 종료이벤트 목록
	@Override
	public List<EventDto> fin_event() throws Exception {
		return sqlSession.selectList(namespace + ".fin_event");
	}

	// 이벤트 보기
	@Override
	public EventDto event_view(String e_code) throws Exception {
		return sqlSession.selectOne(namespace + ".event_view", e_code);
	}

	// 리플리스트 페이징
	@Override
	public PagingDto r_paging(PagingDto pagingDto) throws Exception {
		return sqlSession.selectOne(namespace + ".reply_paging", pagingDto);
	}

	// 리플 리스트
	@Override
	public List<ReplyDto> reply_list(PagingDto pagingDto) throws Exception {
		return sqlSession.selectList(namespace + ".reply_list", pagingDto);
	}

	// 리플 갯수
	@Override
	public int reply_count(String e_code) throws Exception {
		return sqlSession.selectOne(namespace + ".reply_count", e_code);
	}

	// 리플 작성
	@Override
	public int reply(ReplyDto replyDto) throws Exception {
		return sqlSession.insert(namespace + ".reply", replyDto);
	}

	// 리플 수정
	@Override
	public int r_update(ReplyDto replyDto) throws Exception {
		return sqlSession.update(namespace + ".r_update", replyDto);
	}

	// 리플 입력 비밀번호 체크
	@Override
	public String r_pw_ch(ReplyDto replyDto) throws Exception {
		return sqlSession.selectOne(namespace + ".r_pw_ch", replyDto);
	}

	// 리플 삭제
	@Override
	public int r_del(ReplyDto replyDto) throws Exception {
		return sqlSession.delete(namespace + ".r_del", replyDto);
	}

}
