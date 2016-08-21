package com.dava.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.persistence.BoardDao;
import com.dava.myapp.util.Criteria;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao dao;
	
	@Override
	public void delete(Integer bno) {
		dao.delete(bno);
	}

	@Override
	public BoardVO read(Integer bno) {
		return dao.read(bno);
	}

	@Override
	public void insert(BoardVO vo) {
		dao.insert(vo);
	}

	@Override
	public void update(BoardVO vo) {
		dao.update(vo);
	}

	@Override
	public List<BoardVO> list(Criteria cri) {
		return dao.list(cri);
	}

	@Override
	public int totalCount() {
		return dao.totalCount();
	}

	@Override
	public void addViewCount(Integer bno) {
		dao.addViewCount(bno);
		
	}

}
