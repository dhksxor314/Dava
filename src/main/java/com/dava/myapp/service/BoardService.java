package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.util.Search;

public interface BoardService {
	public void write(BoardVO vo);
	public void update(BoardVO vo);
	public void delete(Integer bno);
	public BoardVO read(Integer bno);
	public List<BoardVO> list(int start, int recordPerPage, Search search);
	public int count(Search search);
	public void addviewcnt(Integer bno);
	
}
