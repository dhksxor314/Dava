package com.dava.myapp.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.service.BoardService;
import com.dava.myapp.util.Paging;
import com.dava.myapp.util.Search;


@Controller
@RequestMapping(value="/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/list")
	public String list(Model model, Paging paging, Search search){
		int nowPage = paging.getNowPage();
		int nowBlock = paging.getNowBlock();
		paging = new Paging(service.count(search), nowBlock);
		paging.setNowPage(nowPage);
		paging.setNowBlock(nowBlock);
		paging.setSearch(search);
		model.addAttribute("list", service.list((paging.getNowPage()-1)*paging.getRecordPerPage(), paging.getRecordPerPage(), search));
		model.addAttribute("paging", paging);
		return "/board/list";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public void write(Model model){}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String dowrite(Model model, BoardVO vo){
		service.write(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public String dowrite(Model model, int bno){
		model.addAttribute(service.read(bno));
		return "/board/read";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(Model model, int bno){
		model.addAttribute(service.read(bno));
		return "/board/update";
	}
	
	@RequestMapping(value="/doupdate", method=RequestMethod.POST)
	public String doupdate(RedirectAttributes rttr, BoardVO vo){
		service.update(vo);
		rttr.addAttribute("bno", vo.getBno());
		return "redirect:/board/read";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(Model model, int bno){
		service.delete(bno);
		return "redirect:/board/list";
	}
	
	
	
	
	

	
}
