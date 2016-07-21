package com.dava.myapp.domain;

import java.util.Date;

public class BuyVO {

	private int buynum;
	private int memnum;
	private int booknum;
	private Date buydate;
	private String p_way;
	private int final_pay;

	public int getBuynum() {
		return buynum;
	}

	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}

	public int getMemnum() {
		return memnum;
	}

	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}

	public Date getBuydate() {
		return buydate;
	}

	public void setBuydate(Date buydate) {
		this.buydate = buydate;
	}

	public String getP_way() {
		return p_way;
	}

	public void setP_way(String p_way) {
		this.p_way = p_way;
	}

	public int getFinal_pay() {
		return final_pay;
	}

	public void setFinal_pay(int final_pay) {
		this.final_pay = final_pay;
	}

}
