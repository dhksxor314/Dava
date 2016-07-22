package com.dava.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.domain.MyBookVO;
import com.dava.myapp.persistence.MyBookDao;

@Service
public class MyBookServiceImpl implements MyBookService {

	@Autowired
	private MyBookDao dao;
	
	@Override
	public int getBookmark(int booknum) {
		
		return dao.getBookmark(booknum);
	}

	@Override
	public String getTitle(int booknum) {
		
		return dao.getTitle(booknum);
	}

	@Override
	public String getImage(int booknum) {
		
		return dao.getImage(booknum);
	}

	@Override
	public String setBookmark(MyBookVO vo) {

		return dao.setBookmark(vo);
	}

}
