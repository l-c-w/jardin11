package com.jardin.shop11.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.jardin.shop11.Dao.MemberDao;
import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDao memberDao;

	// 글 리스트 가져오기
	@Override
	public List<BoardDto> list() throws Exception {

		return memberDao.list();
	}

	// 회원가입
	@Override
	public int join(MemberDto memberDto) {
		memberDto
				.setBirth(Date.valueOf(memberDto.getByear() + "-" + memberDto.getBmonth() + "-" + memberDto.getBday()));
		return memberDao.join(memberDto);
	}

	// 아이디 체크
	@Override
	public int checking(HashMap<String, Object> map) throws Exception {
		String id = (String) map.get("id");
		return memberDao.checking(id);
	}

	// 로그인
	@Override
	public int login(MemberDto memberDto, HttpSession session) throws Exception {
		MemberDto result = memberDao.login(memberDto);

		// DB에서 해당 아이디의 비밀번호를 가져와 입력한 비밀번호와 매칭
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

}
