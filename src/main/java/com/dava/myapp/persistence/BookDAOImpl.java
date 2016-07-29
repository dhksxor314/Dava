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
	public List<BookVO> issue() throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectList(namespace + ".issue");
	}

	@Override
	public BookVO select(Integer booknum) throws Exception {
		// TODO Auto-generated method stub
		return SqlSession.selectOne(namespace+".select",booknum);
	}

	@Override
	public List<BookVO> contents(String contents) throws Exception {
		// TODO Auto-generated method stub
	
		return SqlSession.selectList(namespace + ".contents", contents);
	}
	
	@Override
	   public List<BookVO> newstbook() throws Exception {
	      // TODO Auto-generated method stub
	      return SqlSession.selectList(namespace + ".newstbook");
	   }

}
