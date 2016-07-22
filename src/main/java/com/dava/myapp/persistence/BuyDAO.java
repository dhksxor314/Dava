package com.dava.myapp.persistence;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyDAO {

	public void buy(BuyVO vo);
	public void shop_bag(ShopBagVO vo);


	public ShopBagVO bag_select(ShopBagVO vo) throws Exception;
}
