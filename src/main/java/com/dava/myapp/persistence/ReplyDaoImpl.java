package com.dava.myapp.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.ReplyVO;


@Repository
public class ReplyDaoImpl implements ReplyDao {
	
	@Autowired
	private SqlSession session;
	private static final String NAMESPACE = "mappers.replyMapper";

	@Override
	public List<ReplyVO> list(Integer bno) {
		return session.selectList(NAMESPACE+".list", bno);
	}

	@Override
	public void create(ReplyVO vo) {
		session.insert(NAMESPACE+".create", vo);
	}

	@Override
	public void update(ReplyVO vo) {
		session.update(NAMESPACE+".update", vo);
	}

	@Override
	public void delete(Integer rno) {
		session.delete(NAMESPACE+".delete", rno);
	}


}
