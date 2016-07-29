package com.dava.myapp.persistence;

import java.util.List;

public interface MyBookDao {
	public int getBookmark(Integer mybooknum);
	public String getHwp(Integer mybooknum);
	public String getImage(Integer mybooknum);
	public void setBookmark(Integer bookmark, Integer mybooknum);
	public void mybook_insert(Integer memnum);

	public List select_mybooknum(Integer memnum);
}
