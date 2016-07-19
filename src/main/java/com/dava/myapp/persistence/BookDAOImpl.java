package com.dava.myapp.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BookVO;

@Repository
public class BookDAOImpl implements BookDAO {

	@Inject 
	private SqlSession SqlSession;
	
	private static final String namespace = "com.dava.mappers.BookMapper";
	
	@Override
	public List<BookVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookVO select(Integer booknum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(namespace+".select",booknum);
	}

}
