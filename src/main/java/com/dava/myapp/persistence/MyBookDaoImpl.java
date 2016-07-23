package com.dava.myapp.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.MyBookVO;

@Repository
public class MyBookDaoImpl implements MyBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.dava.mappers.MyBookMapper";
	@Override
	public int getBookmark(int booknum) {
		sqlSession.selectOne(namespace+".getBookmark", booknum);
		return 0;
	}

	@Override
	public String getTitle(int booknum) {
		sqlSession.selectOne(namespace+".getTitle", booknum);
		return null;
	}

	@Override
	public String getImage(int booknum) {
		return sqlSession.selectOne(namespace+".getImage", booknum);
	}

	@Override
	public String setBookmark(int mybooknum, int bookmark) {
		int mybook[] = {mybooknum, bookmark};
		return sqlSession.selectOne(namespace+".setBookmark", mybook);
	}



}
