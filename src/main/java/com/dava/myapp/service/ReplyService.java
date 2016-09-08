package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.ReplyVO;


public interface ReplyService {
	public List<ReplyVO> list(Integer bno);
	public void create(ReplyVO vo);
	public void update(ReplyVO vo);
	public void delete(Integer rno);
}
