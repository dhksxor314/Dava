package com.dava.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
	public void detail(@RequestParam("booknum") int booknum, Model model, ShopBagVO shop_vo) throws Exception {

		try {
			model.addAttribute(book_service.select(booknum));
			model.addAttribute(buy_service.bag_select(shop_vo));
			model.addAttribute("check", false);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("check", true);
		}

	}

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void payment(@RequestParam("booknum") int booknum, @RequestParam("memnum") int memnum, Model model)
			throws Exception {

		model.addAttribute(book_service.select(booknum));
		model.addAttribute(mem_service.mem_info(memnum));
	}

	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public void buy(BuyVO vo, Model model) throws Exception {

		try {
			buy_service.buy(vo);

			buy_service.use_point(vo);

			buy_service.point_update(vo);

		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("msg", "이미 구입한 물품입니다.");
		}

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.GET)
	public void total_payment(Model model, HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());

		model.addAttribute("list", buy_service.my_shop(memnum));
		model.addAttribute(mem_service.mem_info(memnum));

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.POST)
	public void total_buy(List<BuyVO> vo,HttpSession session) throws Exception {
		System.out.println(session.getAttribute("total_list"));
		List<BuyVO> total_list = (List)session.getAttribute("total_list");
		System.out.println(total_list.get(0).getBooknum());
		System.out.println(">");
		System.out.println(vo.get(0).getBooknum() );
		System.out.println(vo.get(1).getBooknum() );
		

		
		//buy_service.use_point(vo);
		//buy_service.point_update(vo);

	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public void shop_bag(ShopBagVO shop_vo, @RequestParam("booknum") int booknum, Model model) throws Exception {

		try {
			buy_service.shop_bag(shop_vo);

			model.addAttribute(book_service.select(booknum));

		} catch (Exception e) {
			model.addAttribute(book_service.select(booknum));

		}
	}

	@RequestMapping(value = "/shop_bag", method = RequestMethod.GET)
	public void shop_bag(Model model, HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", buy_service.my_shop(memnum));

	}

	@RequestMapping(value = "/shop_drop", method = RequestMethod.GET)
	public String shop_drop(Model model, ShopBagVO vo, HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		buy_service.shop_drop(vo);
		model.addAttribute("list", buy_service.my_shop(memnum));
		return "/products/shop_bag";

	}

}
