package com.dava.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO mem_info(Integer memnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.mem_info(memnum);
	}

	

}
