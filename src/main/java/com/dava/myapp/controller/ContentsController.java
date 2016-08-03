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
		//컨텐츠 GET접근시.
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="판타지";
		}else if(contents.equals("3")){
			contents ="로맨스";
		}else if(contents.equals("4")){
			contents =search;
		}
		model.addAttribute("contents", contents);
		model.addAttribute("get","get"); //get방식 으로접근하는지 post방식으로 접근하는지 jsp파일에서 알기위해 임의로 준값.
		model.addAttribute("list",service.contents(contents)); //선택 컨텐츠 리스트
		model.addAttribute("choise", choise); 
		model.addAttribute("limit",8);//기본적으로 8개 책만 보여줌.
		return "/contents/contents";
	}
	
	
	@RequestMapping(value = "/contents", method = RequestMethod.POST)
	public String contents_POST(String contents, Model model,int limit,String search) throws Exception {
		//더보기를 눌렀을 시.
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="판타지";
		}else if(contents.equals("3")){
			contents ="로맨스";
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
