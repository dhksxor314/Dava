package com.dava.myapp.persistence;

import com.dava.myapp.domain.MemberVO;

public interface MemberDAO {

	  public MemberVO mem_info(Integer memnum) throws Exception;
	  public void join(MemberVO vo) throws Exception;
	  public MemberVO login(MemberVO vo)throws Exception;
}
