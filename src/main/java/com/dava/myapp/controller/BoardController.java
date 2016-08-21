/*
 * 설명 : 책 읽는 페이지로 이동하면서 해당 책에 맞는 책 정보를 불러온다.
 * 작성자 : 전현영
 */

package com.dava.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dava.myapp.domain.BoardVO;
import com.dava.myapp.service.BoardService;
import com.dava.myapp.util.Criteria;
import com.dava.myapp.util.PageMaker;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public String list(Model model, Criteria cri){
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCount());
		
		model.addAttribute("list", service.list(cri));
		model.addAttribute("pageMaker", pageMaker);
		return "/board/list";
	}
	
	@RequestMapping(value="/board/read", method=RequestMethod.GET)
	public String read(Model model, int bno, @ModelAttribute("cri") Criteria cri){
		service.addViewCount(bno);
		model.addAttribute("boardVO", service.read(bno));
		return "/board/read";
	}
	
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public void write(){}
	
	@RequestMapping(value="/board/dowrite", method=RequestMethod.POST)
	public String dowrite(BoardVO vo){
		service.insert(vo);	
		return "redirect:/board/list";
	}
	
	@RequestMapping(value="/board/update", method=RequestMethod.GET)
	public void update(int bno, Model model){
		BoardVO vo = service.read(bno);
		model.addAttribute("boardVO", vo);
		
	}
	
	@RequestMapping(value="/board/doupdate", method=RequestMethod.POST)
	public String doupdate(BoardVO vo){
		service.update(vo);
		return "redirect:/board/read?bno="+vo.getBno();
	}
	
	@RequestMapping(value="/board/delete")
	public String delete(int bno, Criteria cri, RedirectAttributes rttr){
		service.delete(bno);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("pagePerNum", cri.getPagePerNum());
		return "redirect:/board/list";
	}
	
}
