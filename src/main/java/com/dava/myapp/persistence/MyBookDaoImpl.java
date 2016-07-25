package com.dava.myapp.persistence;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBookDaoImpl implements MyBookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.dava.mappers.MyBookMapper";
	@Override
	public int getBookmark(Integer mybooknum) {
		return sqlSession.selectOne(namespace+".getBookmark", mybooknum);
	}

	@Override
	public String getTitle(Integer mybooknum) {
		return sqlSession.selectOne(namespace+".getTitle", mybooknum);
	}

	@Override
	public String getImage(Integer mybooknum) {
		return sqlSession.selectOne(namespace+".getImage", mybooknum);
	}

	@Override
	public void setBookmark(Integer bookmark, Integer mybooknum) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("bookmark", bookmark);
		paramMap.put("mybooknum", mybooknum);
		
		sqlSession.selectOne(namespace+".setBookmark", paramMap);
	}



}
