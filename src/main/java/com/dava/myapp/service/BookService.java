package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BookVO;

public interface BookService {
	
	  public List<BookVO> listAll() throws Exception;

	  public BookVO select(Integer booknum) throws Exception;


}
