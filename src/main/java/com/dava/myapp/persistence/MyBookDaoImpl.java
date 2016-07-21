package com.dava.myapp.persistence;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBookDaoImpl implements MyBookDao {
	
	@Autowired
	private SqlSession SqlSession;
	
	private static final String namespace = "com.dava.mappers.MyBookMapper";
	@Override
	public int getBookmark() {
		
		return 0;
	}

	@Override
	public String getTitle() {

		return null;
	}

}
