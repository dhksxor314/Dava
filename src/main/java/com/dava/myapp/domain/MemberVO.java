package com.dava.myapp.domain;

public class MemberVO {

	private int memnum;
	private String id;
	private String nickname;
	private String password;
	private String password_check;
	private int point;
	
	
	public String getPassword_check() {
		return password_check;
	}
	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	public int getmemnum() {
		return memnum;
	}
	public void setmemnum(int memnum) {
		this.memnum = memnum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
