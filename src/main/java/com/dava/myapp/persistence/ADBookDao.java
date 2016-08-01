package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.SearchCriteria;

public interface ADBookDao {
	//���� ���
	public void registBook(BookVO bvo) throws Exception;
	
	// ������������ Ȯ��
	public BookVO readBook(Integer booknum) throws Exception;
	// ������������ Ȯ��
	public BookVO readBookBuy(Integer booknum) throws Exception;
	
	//���� ���� ����
	public void updateBook(BookVO bvo) throws Exception;
	
	//���� ����
	public void deleteBook(Integer booknum) throws Exception;
	
	//�������� ���� ���������� ��� List
	public List<BookVO> listBook() throws Exception;
	
	//paging
	public List<BookVO> BooklistPage(int page) throws Exception;
	public List<BookVO> BooklistCriteria(Criteria cri) throws Exception;
	public int BookcountPaging(Criteria cri) throws Exception;
	
	public List<BookVO> BooklistSearch(SearchCriteria cri) throws Exception;
	public int BooklistSearchCount(SearchCriteria cri) throws Exception;
	
}
