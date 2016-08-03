
package com.dava.myapp.persistence;

import java.util.HashMap;
import java.util.List;
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
	public String getHwp(Integer mybooknum) {
		return sqlSession.selectOne(namespace+".getHwp", mybooknum);
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

	@Override
	public void mybook_insert(Integer memnum) {
		// TODO Auto-generated method stub

		sqlSession.selectOne(namespace+".mybook_insert",memnum);
	}

	@Override
	public List select_mybooknum(Integer memnum) {
		// TODO Auto-generated method stub
		return  sqlSession.selectList(namespace+".select_mybooknum", memnum);
		
	}
	


}
