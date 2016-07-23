package com.dava.myapp.service;

public interface MyBookService {
	public int getBookmark(Integer mybooknum);
	public String getTitle(Integer mybooknum);
	public String getImage(Integer mybooknum);
	public void setBookmark(Integer bookmark, Integer mybooknum);
}
