package com.dava.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dava.myapp.persistence.MyBookDao;

@Service
public class MyBookServiceImpl implements MyBookService {

	@Autowired
	private MyBookDao dao;
	
	@Override
	public int getBookmark(Integer mybooknum) {
		return dao.getBookmark(mybooknum);
	}

	@Override
	public String getHwp(Integer mybooknum) {
		return dao.getHwp(mybooknum);
	}

	@Override
	public String getImage(Integer mybooknum) {
		
		return dao.getImage(mybooknum);
	}

	@Override
	public void setBookmark(Integer bookmark, Integer mybooknum) {

		dao.setBookmark(bookmark, mybooknum);
	}

	@Override
	public void mybook_insert(Integer memnum) {
		// TODO Auto-generated method stub
		dao.mybook_insert(memnum);
	}

}
