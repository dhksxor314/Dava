package com.dava.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dava.myapp.persistence.FindPwDao;

@Service
public class FindPwServiceImpl implements FindPwService {
	
	@Inject
	private FindPwDao dao;
	
	@Override
	public String findPw(String id) {
		return dao.findPw(id);
	}

}
