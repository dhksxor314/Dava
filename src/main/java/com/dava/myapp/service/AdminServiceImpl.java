package com.dava.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.domain.SearchCriteria;
import com.dava.myapp.persistence.ADBookDaoImpl;
import com.dava.myapp.persistence.BuyDAOImpl;
import com.dava.myapp.persistence.MemberDAO;

@Service
public class AdminServiceImpl implements AdminService {
	@Inject
	private MemberDAO Mdao;
	@Inject
	private ADBookDaoImpl Bdao;
	@Inject
	private BuyDAOImpl Buydao;

	@Override
	public void registBook(BookVO bvo) throws Exception {
		Bdao.registBook(bvo);
	}

	@Override
	public BookVO readBook(Integer booknum) throws Exception {
		return Bdao.readBook(booknum);
	}

	@Override
	public BookVO readBookBuy(Integer booknum) throws Exception {
		return Bdao.readBookBuy(booknum);
	}

	@Override
	public void updateBook(BookVO bvo) throws Exception {
		Bdao.updateBook(bvo);
	}

	@Override
	public void deleteBook(Integer booknum) throws Exception {
		Bdao.deleteBook(booknum);
	}

	@Override
	public void deleteMember(Integer memnum) throws Exception {
		Mdao.deleteMember(memnum);
	}

	@Override
	public List<MemberVO> listMember() throws Exception {
		return Mdao.listMember();
	}

	@Override
	public MemberVO readMember(Integer memnum) throws Exception {
		return Mdao.readMember(memnum);
	}

	@Override
	public List<BookVO> listBook() throws Exception {
		return Bdao.listBook();
	}

	// 페이징
	@Override
	public List<BookVO> BooklistCriteria(Criteria cri) throws Exception {

		return Bdao.BooklistCriteria(cri);
	}

	@Override
	public int BooklistCountCriteria(Criteria cri) throws Exception {
		return Bdao.BookcountPaging(cri);
	}

	// 검색
	@Override
	public List<BookVO> BooklistSearchCriteria(SearchCriteria cri) throws Exception {
		return Bdao.BooklistSearch(cri);
	}

	@Override
	public int BooklistSearchCount(SearchCriteria cri) throws Exception {
		return Bdao.BooklistSearchCount(cri);
	}

	// 회원 검색
	@Override
	public List<MemberVO> MemberlistCriteria(Criteria cri) throws Exception {
		return Mdao.MemberlistCriteria(cri);
	}

	@Override
	public int MemberlistCountCriteria(Criteria cri) throws Exception {
		return Mdao.MembercountPaging(cri);
	}

	@Override
	public List<MemberVO> MemberlistSearchCriteria(SearchCriteria cri) throws Exception {
		return Mdao.MemberlistSearch(cri);
	}

	@Override
	public int MemberlistSearchCount(SearchCriteria cri) throws Exception {
		return Mdao.MemberlistSearchCount(cri);
	}

	@Override
	public List<BuyVO> BuylistCriteria(Criteria cri) throws Exception {

		return Buydao.BuylistCriteria(cri);
	}

	@Override
	public int BuylistCountCriteria(Criteria cri) throws Exception {
		return Buydao.BuycountPaging(cri);
	}

	@Override
	public BuyVO readBuy(Integer buynum) throws Exception {

		return Buydao.readBuy(buynum);
	}

	@Override
	public void deleteBuy(Integer buynum) throws Exception {
		Buydao.deleteBuy(buynum);
	}

	public void deleteMy(Integer buynum) throws Exception {
		Buydao.deleteMy(buynum);
	}

	@Override
	public List<BuyVO> listBuy() throws Exception {

		return Buydao.listBuy();
	}

}
