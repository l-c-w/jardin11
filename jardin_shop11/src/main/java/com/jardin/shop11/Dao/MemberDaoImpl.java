package com.jardin.shop11.Dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jardin.shop11.Dto.BoardDto;
import com.jardin.shop11.Dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Inject
	SqlSession sqlSession;

	private static String namespace = "com.jardin.shop11.Dao.MemberDao";

	// 글리스트 가져오기
	@Override
	public List<BoardDto> list() throws Exception {

		return sqlSession.selectList(namespace + ".list");
	}

	// 회원가입
	@Override
	public int join(MemberDto memberDto) {

		return sqlSession.insert(namespace + ".join", memberDto);
	}

	// 아이디 체크
	@Override
	public int checking(String id) throws Exception {

		return sqlSession.selectOne(namespace + ".checking", id);
	}

	// 로그인
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {

		return sqlSession.selectOne(namespace + ".login", memberDto);
	}

}
