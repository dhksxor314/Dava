package com.dava.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.persistence.BuyDAO;
import com.dava.myapp.persistence.MemberDAO;

@Repository
public class BuyServiceImpl implements BuyService {
	@Inject
	private BuyDAO dao;

	@Override
	public void buy(BuyVO vo) {
		// TODO Auto-generated method stub
		dao.buy(vo);
	}


	
}
