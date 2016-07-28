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
	public String contents(String contents, Model model) throws Exception {
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="판타지";
		}else if(contents.equals("3")){
			contents ="로맨스";
		}
		model.addAttribute("contents", contents);
		model.addAttribute("get","get");
		model.addAttribute("list",service.contents(contents));
		model.addAttribute("choise", choise);
		model.addAttribute("limit",8);
		return "/contents/contents";
	}
	
	
	@RequestMapping(value = "/contents", method = RequestMethod.POST)
	public String contents_POST(String contents, Model model,int limit) throws Exception {
		System.out.println(limit);
		int choise =  Integer.parseInt(contents);
		if(contents.equals("1")){
			contents ="";
		}else if(contents.equals("2")){
			contents ="판타지";
		}else if(contents.equals("3")){
			contents ="로맨스";
		}
		limit = limit +8;
		
		
		model.addAttribute("contents", contents);
		model.addAttribute("list",service.contents(contents));
		model.addAttribute("choise", choise);
		model.addAttribute("limit", limit);
	
		
		return "/contents/contents";
	}
}
