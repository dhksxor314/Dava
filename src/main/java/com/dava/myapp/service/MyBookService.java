package com.dava.myapp.service;

import com.dava.myapp.domain.MyBookVO;

public interface MyBookService {
	public int getBookmark(int booknum);
	public String getTitle(int booknum);
	public String getImage(int booknum);
	public String setBookmark(MyBookVO vo);
}
