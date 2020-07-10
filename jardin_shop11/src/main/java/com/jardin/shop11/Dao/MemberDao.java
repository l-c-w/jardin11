package com.jardin.shop11.Dao;

import java.util.List;

import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.MemberDto;

public interface MemberDao {

	// 글 리스트 가져오기
	public List<BoardDto> list() throws Exception;

	// 회원가입
	public int join(MemberDto memberDto);

	// 아이디 체크
	public int checking(String id) throws Exception;

	// 로그인
	public MemberDto login(MemberDto memberDto) throws Exception;

}
