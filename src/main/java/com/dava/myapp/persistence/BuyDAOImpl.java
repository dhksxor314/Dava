package com.dava.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.ShopBagVO;

@Repository
public class BuyDAOImpl implements BuyDAO {
	@Inject
	private SqlSession SqlSession;
	private static final String NAMESPACE = "com.dava.mappers.BuyMapper";
	private static final String namespace = "mappers.adminMapper";

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
	public List<BookVO> my_shop(int memnum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList(NAMESPACE + ".my_shop",memnum);
	}

	@Override
	public void shop_drop(ShopBagVO vo) {
		// TODO Auto-generated method stub
		SqlSession.delete(NAMESPACE + ".shop_drop", vo);
	}

	@Override
	public void point_update(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update(NAMESPACE+".point_update",vo);
	}

	@Override
	public void use_point(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update(NAMESPACE+".use_point",vo);
	}

	@Override
	public void total_buy(BuyVO vo) {
		// TODO Auto-generated method stub
		SqlSession.insert(NAMESPACE + ".total_buy", vo);
	}

	@Override
	public void shop_drop_all(ShopBagVO vo) {
		// TODO Auto-generated method stub
		SqlSession.delete(NAMESPACE + ".shop_drop_all", vo);
	}

	@Override
	public List<BuyVO> buy_select(int memnum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList(NAMESPACE + ".buy_select",memnum);
	}

	@Override
	public List<BookVO> mypage_buy(int memnum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList(NAMESPACE + ".mypage_buy",memnum);
	}



	@Override
	public List<BuyVO> listBuy() {
		System.out.println("buydaoimpl");
		return SqlSession.selectList(namespace + ".listBuy");
	}
	
	@Override
	public BuyVO readBuy(Integer buynum) throws Exception {
		return SqlSession.selectOne(namespace + ".readBuy", buynum);
	}

	@Override
	public void deleteBuy(Integer buynum) throws Exception {
		SqlSession.delete(namespace + ".deleteBuy", buynum);
	}
	
	@Override
	public void deleteMy(Integer buynum) throws Exception {
		SqlSession.delete(namespace + ".deleteMy", buynum);
	}

	@Override
	public List<BuyVO> BuylistPage(int page) throws Exception {
		if(page <=0){
			page = 1;
		}
		page = (page - 1) * 10;
		return SqlSession.selectList(namespace + ".BuylistPage", page);
	}

	@Override
	public List<BuyVO> BuylistCriteria(Criteria cri) throws Exception {
		return SqlSession.selectList(namespace + ".BuylistCriteria", cri);
	}
	
	@Override
	public int BuycountPaging(Criteria cri) throws Exception{
		return SqlSession.selectOne(namespace + ".BuycountPaging", cri);
	}

	@Override
	public void sal_update(BuyVO vo) throws Exception {
		// TODO Auto-generated method stub
		SqlSession.update(NAMESPACE+".sal_update",vo);
	}

}
