package com.dava.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BookVO;
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

	@Override
	public ShopBagVO bag_select(ShopBagVO vo) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(NAMESPACE + ".bag_select", vo);
	}

	@Override
	public List<BookVO> my_shop() throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList(NAMESPACE + ".my_shop");
	}

	@Override
	public void shop_drop(int booknum) {
		// TODO Auto-generated method stub
		SqlSession.delete(NAMESPACE + ".shop_drop", booknum);
	}


}
