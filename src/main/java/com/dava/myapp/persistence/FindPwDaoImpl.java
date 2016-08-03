/*
 * 작성자 : 전현영
 * 설명 : 비밀번호 찾기 시 사용
 */

package com.dava.myapp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FindPwDaoImpl implements FindPwDao {

	@Inject
	private SqlSession sqlSession;
	@Inject
	private static final String NAMESPACE = "com.dava.mappers.FindPwMapper";
	
	@Override
	public String findPw(String id) {		
		return sqlSession.selectOne(NAMESPACE+".findPw", id);
	}
	


}
