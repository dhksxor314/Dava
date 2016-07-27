package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.ShopBagVO;

public interface BuyDAO {

	public void buy(BuyVO vo);

	public void shop_bag(ShopBagVO vo);

	public ShopBagVO bag_select(ShopBagVO vo) throws Exception;

	public List<BookVO> my_shop(int memnum) throws Exception;

	public void shop_drop(ShopBagVO vo);

	public void shop_drop_all(ShopBagVO vo);

	public void point_update(BuyVO vo) throws Exception;

	public void use_point(BuyVO vo) throws Exception;

	public void total_buy(BuyVO vo);

	public List<BuyVO> buy_select(int memnum) throws Exception;

	public List<BookVO> mypage_buy(int memnum) throws Exception;


	// ????
	public BuyVO readBuy(Integer buynum) throws Exception;

	// 결제관리 삭제
	public void deleteBuy(Integer booknum) throws Exception;

	// 결제관리 메인 페이지에서 출력 List
	public List<BuyVO> listBuy() throws Exception;

	// paging
	public List<BuyVO> listPage(int page) throws Exception;

	public List<BuyVO> listCriteria(Criteria cri) throws Exception;


}
