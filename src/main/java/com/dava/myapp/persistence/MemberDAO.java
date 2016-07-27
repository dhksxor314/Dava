package com.dava.myapp.persistence;

import java.util.List;

import com.dava.myapp.domain.MemberVO;

public interface MemberDAO {
	// 회원 삭제
	public void deleteMember(Integer memnum) throws Exception;



	  public void editpassword(MemberVO vo) throws Exception;

	// 회원관리 메인 화면 출력 List
	public List<MemberVO> listMember() throws Exception;

	// 결제 관리에서 회원 번호 클릭시 회원정보 확인만 가능하도록
	public MemberVO readMember(Integer memnum) throws Exception;

	public MemberVO mem_info(Integer memnum) throws Exception;

	public void join(MemberVO vo) throws Exception;

	public MemberVO login(MemberVO vo) throws Exception;

}
