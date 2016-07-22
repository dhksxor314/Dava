package com.dava.myapp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;

@Repository
public class BuyDAOImpl implements BuyDAO {
	@Inject
	private SqlSession SqlSession;
	private static final String NAMESPACE = "com.dava.mappers.BuyMapper";

	@Override
	public void buy(BuyVO vo) {
		// TODO Auto-generated method stub
		SqlSession.insert(NAMESPACE + ".buy", vo);
	}

	@Override
	public void shop_bag(ShopBagVO vo) {
		// TODO Auto-generated method stub

		SqlSession.insert(NAMESPACE + ".shop_bag", vo);
	}

}
