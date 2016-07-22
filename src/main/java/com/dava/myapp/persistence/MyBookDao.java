package com.dava.myapp.persistence;

import com.dava.myapp.domain.MyBookVO;

public interface MyBookDao {
	public int getBookmark(int booknum);
	public String getTitle(int booknum);
	public String getImage(int booknum);
	public String setBookmark(MyBookVO vo);
}
