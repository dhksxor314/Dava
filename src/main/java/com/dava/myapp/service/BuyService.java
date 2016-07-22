package com.dava.myapp.service;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyService {

	public void buy(BuyVO vo);

	public void shop_bag(ShopBagVO vo);

	public ShopBagVO bag_select(ShopBagVO vo) throws Exception;

}
