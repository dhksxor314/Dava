package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;

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
	public List<BookVO> listPage(int page) throws Exception;
	public List<BookVO> listCriteria(Criteria cri) throws Exception;
	
}
