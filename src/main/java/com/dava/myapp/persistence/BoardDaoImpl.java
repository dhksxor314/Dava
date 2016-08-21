package com.dava.myapp.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.util.Criteria;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private static final String NAMESPACE = "mappers.boardMapper";
	@Override
	public void delete(Integer bno) {
		session.delete(NAMESPACE+".delete", bno);
	}

	@Override
	public BoardVO read(Integer bno) {
		return session.selectOne(NAMESPACE+".read", bno);
	}

	@Override
	public void insert(BoardVO vo) {
		session.insert(NAMESPACE+".insert", vo);
	}

	@Override
	public void update(BoardVO vo) {
		session.update(NAMESPACE+".update", vo);
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return session.selectList(NAMESPACE+".list", cri);
	}

	@Override
	public int totalCount() {
		return session.selectOne(NAMESPACE+".count");
	}

	@Override
	public void addViewCount(Integer bno) {
		session.update(NAMESPACE+".add", bno);
	}

}
