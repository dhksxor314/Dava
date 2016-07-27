package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.MemberVO;

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

}
