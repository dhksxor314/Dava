package com.dava.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession SqlSession;

	private static final String namespace = "com.dava.mappers.MemMapper";
	private static final String NAMESPACE = "mappers.adminMapper";

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
	
	@Override
	public List<MemberVO> listMember() {
		
		return SqlSession.selectList(NAMESPACE + ".listMember");
	}

	@Override
	public void deleteMember(Integer memnum) throws Exception {
		SqlSession.delete(NAMESPACE + ".deleteMember", memnum);
	}

	@Override
	public MemberVO readMember(Integer memnum) throws Exception {
		return SqlSession.selectOne(NAMESPACE + ".readMember", memnum);
	}

}
