package com.dava.myapp.util;

public class Criteria {
	private int page;
	private int pagePerNum;
	
	public Criteria(){
		this.page=1;
		this.pagePerNum=10;
	}
	
	public void setPage(int page){
		if(page<=0){
			this.page=1;
			return;
		}
		this.page=page;
	}
	
	public void setPerPageNum(int pagePerNum){
		if(pagePerNum <= 0 || pagePerNum>100){
			this.pagePerNum=10;
			return;
		}
		this.pagePerNum=pagePerNum;
	}
	
	public int getPage(){
		return page;
	}
	
	public int getPageStart(){
		return (this.page-1)*pagePerNum;
	}
	
	public int getPagePerNum(){
		return this.pagePerNum;
	}

	@Override
	public String toString() {
		return "Criteria [page="+page+","+"pagePerNum="+pagePerNum+"]";
	}
	
	
}
