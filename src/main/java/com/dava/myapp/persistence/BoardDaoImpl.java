package com.dava.myapp.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.util.Search;


@Repository
public class BoardDaoImpl implements BoardDao {

	private static final String NAMESPACE = "mappers.boardMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public void write(BoardVO vo) {
		session.insert(NAMESPACE+".write", vo);

	}

	@Override
	public void update(BoardVO vo) {
		session.update(NAMESPACE+".update", vo);

	}

	@Override
	public void delete(Integer bno) {
		session.delete(NAMESPACE+".delete", bno);
	}

	@Override
	public BoardVO read(Integer bno) {
		return session.selectOne(NAMESPACE+".read", bno);
	}

	@Override
	public List<BoardVO> list(int start, int recordPerPage, Search search) {
		Map<String, Object> map = new HashMap<>();
		map.put("start", start);
		map.put("recordPerPage", recordPerPage);
		map.put("search", search);

		return session.selectList(NAMESPACE+".list", map);
	}
	
	@Override
	public int count(Search search) {
		return session.selectOne(NAMESPACE+".count", search);
	}

	@Override
	public void addviewcnt(Integer bno) {
		session.update(NAMESPACE+".addviewcnt", bno);
		
	}

}
