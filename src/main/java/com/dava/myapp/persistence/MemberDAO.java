package com.dava.myapp.persistence;

import com.dava.myapp.domain.MemberVO;

public interface MemberDAO {

	  public MemberVO mem_info(Integer memnum) throws Exception;
}
