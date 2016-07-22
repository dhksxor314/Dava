package com.dava.myapp.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBookDaoImpl implements MyBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.dava.mappers.MyBookMapper";
	@Override
	public int getBookmark() {
		sqlSession.selectOne(namespace+".getBookmark");
		return 0;
	}

	@Override
	public String getTitle() {
		sqlSession.selectOne(namespace+".getTitle");
		return null;
	}

	@Override
	public String getImage() {
		return sqlSession.selectOne(namespace+".getImage");
	}

	@Override
	public String setBookmark(int bookmark) {		
		return sqlSession.selectOne(namespace+".setBookmark", bookmark);
	}



}
