package com.dava.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;
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

	@Override
	public void shop_bag(ShopBagVO vo) {
		// TODO Auto-generated method stub
		dao.shop_bag(vo);
	}


	@Override
	public ShopBagVO bag_select(ShopBagVO vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.bag_select(vo);

	}

	
}
