package com.dava.myapp.service;

public interface MyBookService {
	public int getBookmark(int booknum);
	public String getTitle(int booknum);
	public String getImage(int booknum);
	public String setBookmark(int mybooknum, int bookmark);
}
