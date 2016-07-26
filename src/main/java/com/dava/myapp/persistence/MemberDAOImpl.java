package com.dava.myapp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession SqlSession;

	private static final String namespace = "com.dava.mappers.MemMapper";

	@Override
	public MemberVO mem_info(Integer memnum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(namespace + ".mem_info", memnum);
	}

	@Override
	public void join(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		SqlSession.insert(namespace+".join",vo);
		
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(namespace+".login",vo);
	}

}
