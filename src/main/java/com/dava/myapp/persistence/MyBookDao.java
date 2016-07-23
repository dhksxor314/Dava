package com.dava.myapp.persistence;

public interface MyBookDao {
	public int getBookmark(int mybooknum);
	public String getTitle(int mybooknum);
	public String getImage(int mybooknum);
	public String setBookmark(int mybooknum, int bookmark);
}
