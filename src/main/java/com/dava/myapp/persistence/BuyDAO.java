package com.dava.myapp.persistence;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyDAO {

	public void buy(BuyVO vo);
	public void shop_bag(ShopBagVO vo);
}
