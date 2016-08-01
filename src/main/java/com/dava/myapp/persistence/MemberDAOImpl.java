package com.dava.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.Criteria;
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

	@Override
	public void editpassword(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update(namespace+".editpassword",vo);
	}

	@Override
	public List<MemberVO> MemberlistPage(int page) throws Exception{
		if(page <= 0){
			page =1;
		}
		
		page = (page-1) * 10;
		
		return SqlSession.selectList(NAMESPACE + ".MemberlistPage", page);
	}
	@Override
	public List<MemberVO> MemberlistCriteria(Criteria cri) throws Exception{
		return SqlSession.selectList(NAMESPACE + ".MemberlistCriteria", cri);
	}
	@Override
	public int MembercountPaging(Criteria cri) throws Exception{
		return SqlSession.selectOne(NAMESPACE + ".MembercountPaging", cri);
	}

	@Override
	public String pwsearch(String id) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(namespace+".pwsearch", id);
	}
}
