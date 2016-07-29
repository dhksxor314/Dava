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
import com.dava.myapp.service.MyBookService;

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
	@Inject
	private MyBookService mubook_service;
	

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
	public void buy(BuyVO vo, Model model,ShopBagVO shop_vo) throws Exception {

		try {
			buy_service.buy(vo);
			mubook_service.mybook_insert();
			buy_service.use_point(vo);

			buy_service.point_update(vo);
			buy_service.sal_update(vo);
			
			
			buy_service.shop_drop(shop_vo);

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
	public void total_buy(HttpSession session, BuyVO vo, int use_point, String p_way, int final_pay, ShopBagVO shop_vo,
			Model model) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());

		int size = buy_service.my_shop(memnum).size();
		int buy_size = buy_service.buy_select(memnum).size();
		System.out.println("size:" +buy_size);
		
		for(int i=0 ; i<size; i++){
			for(int j=0; j<buy_size; j++){
				if(	buy_service.my_shop(memnum).get(i).getBooknum() == buy_service.buy_select(memnum).get(j).getBooknum()){
					
					model.addAttribute("msg", "선택하신 상품을 이미 보유중입니다 \\n 마이페이지에서 확인해 주세요.");
					return;
					
				}
			}
		}
		
		
		for (int i = 0; i < size; i++) {
			vo.setMemnum(memnum);
			vo.setBooknum(buy_service.my_shop(memnum).get(i).getBooknum());
			vo.setFinal_pay(buy_service.my_shop(memnum).get(i).getPrice() - (use_point / size));
			vo.setP_way(p_way);
			vo.setUse_point(use_point);
			buy_service.buy(vo);
			buy_service.sal_update(vo);

			mubook_service.mybook_insert();

		}

		shop_vo.setMemnum(memnum);
		buy_service.shop_drop_all(shop_vo);
		
		vo.setFinal_pay(final_pay);
		buy_service.use_point(vo);
		buy_service.point_update(vo);
		
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public void shop_bag(ShopBagVO shop_vo, @RequestParam("booknum") int booknum, Model model,BuyVO vo,HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		int buy_size = buy_service.buy_select(memnum).size();
		
			for(int j=0; j<buy_size; j++){
				if(	buy_service.buy_select(memnum).get(j).getBooknum()  == booknum){
					
					model.addAttribute("msg", "이미 구입한 상품 입니다.");
					model.addAttribute(book_service.select(booknum));
					return;
					
				}
			}
		
		
		
		try {
			
			buy_service.shop_bag(shop_vo);
			model.addAttribute(book_service.select(booknum));

		} catch (Exception e) {
			System.err.println("2");
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("msg", "이미 장바구니에 담겨있습니다..");

			

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
