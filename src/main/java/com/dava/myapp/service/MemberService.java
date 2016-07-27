package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.MemberVO;

public interface MemberService {

	public MemberVO mem_info(Integer memnum) throws Exception;

	public void join(MemberVO vo) throws Exception;
	
	  public MemberVO login(MemberVO vo)throws Exception;
	  
	  public void editpassword(MemberVO vo) throws Exception;
}
