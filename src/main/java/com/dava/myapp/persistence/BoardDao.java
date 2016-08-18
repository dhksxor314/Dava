package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BoardVO;

public interface BoardDao {
	
	public void delete(Integer bno);
	public BoardVO read(Integer bno);
	public void insert(BoardVO vo);
	public void update(BoardVO vo);
	
	public List<BoardVO> list();
	public int totalCount();
	
}
