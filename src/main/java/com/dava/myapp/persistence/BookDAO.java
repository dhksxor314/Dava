package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;

public interface BookDAO {
	
	  public List<BookVO> issue() throws Exception;

	  public BookVO select(Integer booknum) throws Exception;
	  
	  public List<BookVO> contents(String contents) throws Exception;


}
