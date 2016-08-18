package com.dava.myapp.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSession session;
	
	private static final String NAMESPACE = "mappers.boardMapper";
	@Override
	public void delete(Integer bno) {
		
	}

	@Override
	public BoardVO read(Integer bno) {
		return null;
	}

	@Override
	public void insert(BoardVO vo) {

	}

	@Override
	public void update(BoardVO vo) {

	}

	@Override
	public List<BoardVO> list() {
		return session.selectList(NAMESPACE+".list");
	}

	@Override
	public int totalCount() {
		return 0;
	}

}
