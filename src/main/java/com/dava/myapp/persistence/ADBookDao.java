package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.SearchCriteria;

public interface ADBookDao {
	//도서 등록
	public void registBook(BookVO bvo) throws Exception;
	
	// 도서관리에서 확인
	public BookVO readBook(Integer booknum) throws Exception;
	// 결제관리에서 확인
	public BookVO readBookBuy(Integer booknum) throws Exception;
	
	//도서 정보 수정
	public void updateBook(BookVO bvo) throws Exception;
	
	//도서 삭제
	public void deleteBook(Integer booknum) throws Exception;
	
	//도서관리 메인 페이지에서 출력 List
	public List<BookVO> listBook() throws Exception;
	
	//paging
	public List<BookVO> BooklistPage(int page) throws Exception;
	public List<BookVO> BooklistCriteria(Criteria cri) throws Exception;
	public int BookcountPaging(Criteria cri) throws Exception;
	
	public List<BookVO> BooklistSearch(SearchCriteria cri) throws Exception;
	public int BooklistSearchCount(SearchCriteria cri) throws Exception;
	
}
