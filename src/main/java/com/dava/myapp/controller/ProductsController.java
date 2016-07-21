package com.dava.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.service.BookService;
import com.dava.myapp.service.BuyService;
import com.dava.myapp.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/products/*")
public class ProductsController {
	@Inject
	private BookService book_service;
	@Inject
	private MemberService mem_service;
	@Inject
	private BuyService buy_service;

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public void detail(@RequestParam("booknum") int booknum, Model model) throws Exception {

		model.addAttribute(book_service.select(booknum));
	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void payment(@RequestParam("booknum") int booknum, @RequestParam("memnum") int memnum, Model model)
			throws Exception {

		model.addAttribute(book_service.select(booknum));
		model.addAttribute(mem_service.mem_info(memnum));
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public void buy(BuyVO vo) throws Exception {
		System.out.println("ÀÌ°Å³Ä?");

		System.out.println("book:"+vo.getBooknum());
		System.out.println("mem:"+vo.getMemnum());
		System.out.println("p_way:"+vo.getP_way());
		System.out.println("final:"+vo.getFinal_pay());
		
		buy_service.buy(vo);
		
	}

}
