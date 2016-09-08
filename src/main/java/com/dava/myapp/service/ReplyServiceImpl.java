package com.dava.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.domain.ReplyVO;
import com.dava.myapp.persistence.ReplyDao;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyDao dao;
	
	@Override
	public List<ReplyVO> list(Integer bno) {
		return dao.list(bno);
	}

	@Override
	public void create(ReplyVO vo) {
		dao.create(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		dao.update(vo);
	}

	@Override
	public void delete(Integer rno) {
		dao.delete(rno);
	}

}
