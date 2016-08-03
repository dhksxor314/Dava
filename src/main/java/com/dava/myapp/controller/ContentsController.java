package com.dava.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dava.myapp.service.BookService;

@Controller
@RequestMapping("/contents/*")
public class ContentsController {
	@Inject
	private BookService service;

	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public String contents(String contents, Model model,String search) throws Exception {
		//������ GET���ٽ�.
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="��Ÿ��";
		}else if(contents.equals("3")){
			contents ="�θǽ�";
		}else if(contents.equals("4")){
			contents =search;
		}
		model.addAttribute("contents", contents);
		model.addAttribute("get","get"); //get��� ���������ϴ��� post������� �����ϴ��� jsp���Ͽ��� �˱����� ���Ƿ� �ذ�.
		model.addAttribute("list",service.contents(contents)); //���� ������ ����Ʈ
		model.addAttribute("choise", choise); 
		model.addAttribute("limit",8);//�⺻������ 8�� å�� ������.
		return "/contents/contents";
	}
	
	
	@RequestMapping(value = "/contents", method = RequestMethod.POST)
	public String contents_POST(String contents, Model model,int limit,String search) throws Exception {
		//�����⸦ ������ ��.
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="��Ÿ��";
		}else if(contents.equals("3")){
			contents ="�θǽ�";
		}else if(contents.equals("4")){
			contents =search;
		}
		limit = limit +8;
		
		model.addAttribute("contents", contents);
		model.addAttribute("list",service.contents(contents));
		model.addAttribute("choise", choise);
		model.addAttribute("limit", limit);
	
		
		return "/contents/contents";
	}
	

}
