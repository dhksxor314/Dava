package com.dava.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
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
		return dao.list();
	}

	@Override
	public int totalCount() {
		return 0;
	}

}
