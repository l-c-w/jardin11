package com.jardin.shop11.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.MemberDto;

public interface MemberService {

	// 글 리스트 가져오기
	public List<BoardDto> list() throws Exception;

	// 회원가입
	public int join(MemberDto memberDto);

	// 아이디 체크
	public int checking(HashMap<String, Object> map) throws Exception;

	// 로그인
	public int login(MemberDto memberDto, HttpSession session) throws Exception;

}
