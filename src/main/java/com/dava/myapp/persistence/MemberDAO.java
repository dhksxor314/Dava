package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.domain.SearchCriteria;

public interface MemberDAO {
	// ȸ�� ����
	public void deleteMember(Integer memnum) throws Exception;

	public void editpassword(MemberVO vo) throws Exception;

	// ȸ������ ���� ȭ�� ��� List
	public List<MemberVO> listMember() throws Exception;

	// ���� �������� ȸ�� ��ȣ Ŭ���� ȸ������ Ȯ�θ� �����ϵ���
	public MemberVO readMember(Integer memnum) throws Exception;

	public MemberVO mem_info(Integer memnum) throws Exception;

	public void join(MemberVO vo) throws Exception;

	public MemberVO login(MemberVO vo) throws Exception;
	
	public MemberVO pwsearch(String id) throws Exception;
	
	//paging
	public List<MemberVO> MemberlistPage(int page) throws Exception;
	public List<MemberVO> MemberlistCriteria(Criteria cri) throws Exception;
	public int MembercountPaging(Criteria cri) throws Exception;
	
	public List<MemberVO> MemberlistSearch(SearchCriteria cri) throws Exception;
	public int MemberlistSearchCount(SearchCriteria cri) throws Exception;

}
