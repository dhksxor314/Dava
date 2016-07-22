package com.dava.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dava.myapp.domain.BuyVO;
import com.dava.myapp.domain.ShopBagVO;
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

		buy_service.buy(vo);

	}

	@RequestMapping(value = "/shop_bag", method = RequestMethod.POST)
	public void shop_bag(ShopBagVO vo) throws Exception {
		
		
		buy_service.shop_bag(vo);

	}

}
