package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.BookVO;

public interface BookDAO {
	
	  public List<BookVO> listAll() throws Exception;

	  public BookVO select(Integer booknum) throws Exception;


}
