package com.jardin.shop11.Service;

import java.io.File;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jardin.shop11.Dao.BoardDao;
import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.EventDto;
import com.jardin.shop11.Dto.MemberDto;
import com.jardin.shop11.Dto.PagingDto;
import com.jardin.shop11.Dto.ReplyDto;
import com.jardin.shop11.Dto.SearchingDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	BoardDao boardDao;

	// 글 리스트 가져오기
	@Override
	public List<BoardDto> list() throws Exception {

		return boardDao.list();
	}

	// 회원가입
	@Override
	public int join(MemberDto memberDto) {
		memberDto
				.setBirth(Date.valueOf(memberDto.getByear() + "-" + memberDto.getBmonth() + "-" + memberDto.getBday()));
		return boardDao.join(memberDto);
	}

	// 아이디 체크
	@Override
	public int checking(String id) throws Exception {

		return boardDao.checking(id);
	}

	// 로그인
	@Override
	public int login(MemberDto memberDto, HttpSession session) throws Exception {
		MemberDto result = boardDao.login(memberDto);
		int resulttype = 0;

		if (result == null) {
			resulttype = 2;
		} else if (memberDto.getPw().equals(result.getPw())) {
			session.setAttribute("user_id", result.getId());
			resulttype = 1;
		} else {
			resulttype = 3;
		}

		return resulttype;
	}

	// 이벤트 등록
	@Override
	public int event_write(EventDto eventDto, MultipartHttpServletRequest request) throws Exception {
		String path = "D:/workspace/jardin_shop11/src/main/webapp/uploadimages/";
		UUID uuid = UUID.randomUUID();
		MultipartFile mf1 = request.getFile("thumb");
		MultipartFile mf2 = request.getFile("conpic");
		String file1 = uuid.toString() + "_" + mf1.getOriginalFilename();
		String file2 = uuid.toString() + "_" + mf2.getOriginalFilename();
		mf1.transferTo(new File(path + file1));
		mf2.transferTo(new File(path + file2));
		eventDto.setFile1(file1);
		eventDto.setFile2(file2);

		return boardDao.event_write(eventDto);
	}

	// 이벤트 페이징
	@Override
	public PagingDto e_paging(SearchingDto searchingDto, String event_type) throws Exception {
		if (searchingDto.getEvent_type() != null) {
		} else {
			if (event_type == null) {
				event_type = "event";
			}
		}
		searchingDto.setEvent_type(event_type);
		PagingDto pagingDto = boardDao.e_paging(searchingDto);

		pagingDto.setEvent_type(event_type);
		pagingDto.setCurPage(searchingDto.getCurPage());
		pagingDto.setPage_cnt(pagingDto.getListCnt(), pagingDto.getPage_size());
		pagingDto.setRange_cnt(pagingDto.getPage_cnt());
		pagingDto.setCur_range(searchingDto.getCurPage());
		pagingDto.prevnext(searchingDto.getCurPage());
		pagingDto.setStart_page(pagingDto.getCur_range(), pagingDto.getRange_size());
		pagingDto.setEnd_page(pagingDto.getCur_range(), pagingDto.getRange_cnt(), pagingDto.getListCnt());

		return pagingDto;
	}

	// 이벤트 리스트
	@Override
	public List<EventDto> event(SearchingDto searchingDto, String event_type) throws Exception {
		return boardDao.event(searchingDto);
	}

	// 종료이벤트 목록
	@Override
	public List<EventDto> fin_event() throws Exception {
		return boardDao.fin_event();
	}

	// 이벤트 보기
	@Override
	public EventDto event_view(HttpServletRequest request) throws Exception {
		String e_code = request.getParameter("e_code");
		return boardDao.event_view(e_code);
	}

	// 리플 페이징
	@Override
	public PagingDto r_paging(PagingDto pagingDto, HttpServletRequest request) throws Exception {
		int curPage = pagingDto.getCurPage();
		String e_code = request.getParameter("e_code");

		pagingDto.setE_code(e_code);
		pagingDto = boardDao.r_paging(pagingDto);
		pagingDto.setCurPage(curPage);
		pagingDto.setPage_size(10);

		pagingDto.setPage_cnt(pagingDto.getListCnt(), pagingDto.getPage_size());
		pagingDto.setRange_cnt(pagingDto.getPage_cnt());
		pagingDto.setCur_range(pagingDto.getCurPage());
		pagingDto.prevnext(pagingDto.getCurPage());
		pagingDto.setStart_page(pagingDto.getCur_range(), pagingDto.getRange_size());
		pagingDto.setEnd_page(pagingDto.getCur_range(), pagingDto.getRange_cnt(), pagingDto.getListCnt());

		return pagingDto;
	}

	// 리플 리스트
	@Override
	public List<ReplyDto> reply_list(HttpServletRequest request, PagingDto pagingDto) throws Exception {
		String e_code = request.getParameter("e_code");
		pagingDto.setE_code(e_code);

		return boardDao.reply_list(pagingDto);
	}

	// 리플 갯수
	@Override
	public int reply_count(HttpServletRequest request) throws Exception {
		String e_code = request.getParameter("e_code");
		return boardDao.reply_count(e_code);
	}

	// 리플 작성
	@Override
	public int reply(ReplyDto replyDto, HttpSession session) throws Exception {
		String id = (String) session.getAttribute("user_id");
		replyDto.setId(id);
		return boardDao.reply(replyDto);
	}

	// 리플 수정
	@Override
	public int r_update(ReplyDto replyDto) throws Exception {
		String pw = replyDto.getR_pw();
		String pw_ch = boardDao.r_pw_ch(replyDto);
		if (pw == null) {
			return boardDao.r_update(replyDto);

		} else {
			if (pw.equals(pw_ch)) {
				return boardDao.r_update(replyDto);
			} else {
				return -1;
			}
		}
	}

	// 리플 삭제
	@Override
	public int r_del(HashMap<String, Object> map) throws Exception {
		ReplyDto replyDto = new ReplyDto();
		int r_number = Integer.parseInt((String) map.get("r_number"));
		String pw = (String) map.get("r_pw");
		replyDto.setR_pw(pw);
		replyDto.setR_number(r_number);
		String pw_ch = boardDao.r_pw_ch(replyDto);

		if (pw == null) {
			return boardDao.r_del(replyDto);

		} else {
			if (pw.equals(pw_ch)) {
				return boardDao.r_del(replyDto);
			} else {
				return -1;
			}
		}
	}

}
