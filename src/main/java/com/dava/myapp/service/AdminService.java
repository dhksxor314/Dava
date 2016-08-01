package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.domain.SearchCriteria;

public interface AdminService {
	public void registBook(BookVO bvo) throws Exception;

	public BookVO readBook(Integer booknum) throws Exception;

	public BookVO readBookBuy(Integer booknum) throws Exception;

	public void updateBook(BookVO bvo) throws Exception;

	public void deleteBook(Integer booknum) throws Exception;

	public void deleteMember(Integer memnum) throws Exception;

	public BuyVO readBuy(Integer buynum) throws Exception;

	public void deleteBuy(Integer buynum) throws Exception;

	public void deleteMy(Integer buynum) throws Exception;

	//도서 페이징
	public List<BookVO> listBook() throws Exception;
	public List<BookVO> BooklistCriteria(Criteria cri) throws Exception;
	public int BooklistCountCriteria(Criteria cri) throws Exception;

	//도서 검색
	public List<BookVO> BooklistSearchCriteria(SearchCriteria cri) throws Exception;
	public int BooklistSearchCount(SearchCriteria cri) throws Exception;

	//회원 페이징
	public List<MemberVO> listMember() throws Exception;
	public List<MemberVO> MemberlistCriteria(Criteria cri) throws Exception;
	public int MemberlistCountCriteria(Criteria cri) throws Exception;

	//회원 검색
	public List<MemberVO> MemberlistSearchCriteria(SearchCriteria cri) throws Exception;
	public int MemberlistSearchCount(SearchCriteria cri) throws Exception;

	//구매 페이징
	public List<BuyVO> listBuy() throws Exception;
	public List<BuyVO> BuylistCriteria(Criteria cri) throws Exception;
	public int BuylistCountCriteria(Criteria cri) throws Exception;
	
	public MemberVO readMember(Integer memnum) throws Exception;
}
