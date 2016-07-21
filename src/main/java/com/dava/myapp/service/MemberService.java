package com.dava.myapp.service;

import java.util.List;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.MemberVO;

public interface MemberService {
	
	  public MemberVO mem_info(Integer memnum) throws Exception;
}
