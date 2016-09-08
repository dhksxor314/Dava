package com.dava.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.persistence.BoardDao;
import com.dava.myapp.util.Search;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Override
	public void write(BoardVO vo) {
		dao.write(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(Integer bno) {
		dao.delete(bno);
	}

	@Override
	public BoardVO read(Integer bno) {
		return dao.read(bno);
	}

	@Override
	public List<BoardVO> list(int start, int recordPerPage, Search search) {
		return dao.list(start, recordPerPage, search);
	}

	@Override
	public int count(Search search) {
		return dao.count(search);
	}

}
