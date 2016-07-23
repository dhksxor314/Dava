package com.dava.myapp.persistence;

public interface MyBookDao {
	public int getBookmark(Integer mybooknum);
	public String getTitle(Integer mybooknum);
	public String getImage(Integer mybooknum);
	public void setBookmark(Integer bookmark, Integer mybooknum);
}
