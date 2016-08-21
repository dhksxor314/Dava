package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.util.Criteria;

public interface BoardDao {
	
	public void delete(Integer bno);
	public BoardVO read(Integer bno);
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	public void addViewCount(Integer bno);
	public List<BoardVO> list(Criteria cri);
	public int totalCount();
	
}
