package com.dava.myapp.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;


@Repository
public class ADBookDaoImpl {
	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE = "mappers.adminMapper";

	public void registBook(BookVO bvo) throws Exception{
		sqlSession.insert(NAMESPACE + ".registBook", bvo);
	}
	
	public BookVO readBook(Integer booknum) throws Exception{
		return sqlSession.selectOne(NAMESPACE + ".readBook", booknum);
	}
	public BookVO readBookBuy(Integer booknum) throws Exception{
		return sqlSession.selectOne(NAMESPACE + ".readBookBuy", booknum);
	}
	
	public void updateBook(BookVO bvo) throws Exception{
		sqlSession.update(NAMESPACE + ".updateBook", bvo);
	}
	
	public void deleteBook(Integer booknum) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteBook", booknum);
	}
	
	public List<BookVO> listBook() {
		return sqlSession.selectList(NAMESPACE + ".listBook");
	}
	
	
	public List<BookVO> BooklistPage(int page) throws Exception{
		if(page <= 0){
			page =1;
		}
		
		page = (page-1) * 10;
		
		return sqlSession.selectList(NAMESPACE + ".BooklistPage", page);
	}
	
	public List<BookVO> BooklistCriteria(Criteria cri) throws Exception{
		return sqlSession.selectList(NAMESPACE + ".BooklistCriteria", cri);
	}
	
	public int BookcountPaging(Criteria cri) throws Exception{
		return sqlSession.selectOne(NAMESPACE + ".BookcountPaging", cri);
	}
}
