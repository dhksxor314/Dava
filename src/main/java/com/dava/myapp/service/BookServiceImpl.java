package com.dava.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.persistence.BookDAO;
@Service
public class BookServiceImpl implements BookService, BookDAO {

	@Inject
	private BookDAO dao;
	
	@Override
	public List<BookVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO select(Integer booknum) throws Exception {
		// TODO Auto-generated method stub
		return dao.select(booknum);
	}

}
