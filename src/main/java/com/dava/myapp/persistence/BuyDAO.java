package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyDAO {

	public void buy(BuyVO vo);

	public void shop_bag(ShopBagVO vo);

	public ShopBagVO bag_select(ShopBagVO vo) throws Exception;

	public List<BookVO> my_shop(int memnum) throws Exception;
	

	public void shop_drop(ShopBagVO vo);
	

	public void point_update(BuyVO vo) throws Exception;

	public void use_point(BuyVO vo) throws Exception;
}
