package com.dava.myapp.domain;

import java.util.Date;

public class BuyVO {

	private int buynum;
	private int memnum;
	private int booknum;
	private Date buy_date;
	private String p_way;
	private int final_pay;
	private int use_point;
	

	public int getUse_point() {
		return use_point;
	}

	public void setUse_point(int use_point) {
		this.use_point = use_point;
	}

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

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
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
