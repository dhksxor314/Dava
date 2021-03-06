package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyService {

	public void buy(BuyVO vo);

	public void shop_bag(ShopBagVO vo);

	public ShopBagVO bag_select(ShopBagVO vo) throws Exception;
	
	public List<BookVO> my_shop(int memnum) throws Exception;
	

	public void shop_drop(ShopBagVO vo);

	public void shop_drop_all(ShopBagVO vo);
	
	public void point_update(BuyVO vo) throws Exception;
	
	public void sal_update(BuyVO vo) throws Exception;
	
	public void use_point(BuyVO vo) throws Exception;

	public void total_buy(BuyVO vo);
	
	public List<BuyVO> buy_select(int memnum) throws Exception;
	
	public List<BookVO> mypage_buy(int memnum) throws Exception;
	
	public List<BookVO> mypage_buylist(int memnum) throws Exception;
	
	//구입시 검사ㅣ

	public BuyVO buycheck(BuyVO vo) throws Exception;

}
