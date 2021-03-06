package com.dava.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;
import com.dava.myapp.persistence.BuyDAO;

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

	@Override
	public List<BookVO> my_shop(int memnum) throws Exception {
		// TODO Auto-generated method stub
		 return dao.my_shop(memnum);
	}

	@Override
	public void shop_drop(ShopBagVO vo) {
		// TODO Auto-generated method stub
		dao.shop_drop(vo);
	}

	@Override
	public void point_update(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.point_update(vo);
		
	}

	@Override
	public void use_point(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.use_point(vo);
	}

	@Override
	public void total_buy(BuyVO vo) {
		// TODO Auto-generated method stub

		dao.total_buy(vo);
	}

	@Override
	public void shop_drop_all(ShopBagVO vo) {
		// TODO Auto-generated method stub
		dao.shop_drop_all(vo);
	}

	@Override
	public List<BuyVO> buy_select(int memnum) throws Exception {
		// TODO Auto-generated method stub
		 return dao.buy_select(memnum);
	}

	@Override
	public List<BookVO> mypage_buy(int memnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.mypage_buy(memnum);
	}

	@Override
	public void sal_update(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.sal_update(vo);
	}

	@Override
	public List<BookVO> mypage_buylist(int memnum) throws Exception {
		// TODO Auto-generated method stub
		return dao.mypage_buylist(memnum);
	}

	@Override
	public BuyVO buycheck(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		
		return dao.buycheck(vo);
	}
	
	

	
}
