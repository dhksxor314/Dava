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
		//책 설명

		try {
			model.addAttribute(book_service.select(booknum)); //북에대한 정보.
			model.addAttribute(buy_service.bag_select(shop_vo)); // 이미 구입한 상품인지 검사.
			model.addAttribute("check", false); //구입한것인지 아닌지 model로 보내줌.
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("check", true);
		}

	}
	
	
	

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void payment(@RequestParam("booknum") int booknum, @RequestParam("memnum") int memnum, Model model)
			throws Exception {
		//GET방식으로 접근시 결제 페이지로 페이지 이동.

		model.addAttribute(book_service.select(booknum)); //책에대한 정보 
		model.addAttribute(mem_service.mem_info(memnum)); //회원 정보
	}

	
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public void buy(BuyVO vo, Model model,ShopBagVO shop_vo, HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
			//POST방식으로 접근시. 결제. 
		
		
		if( buy_service.buycheck(vo) == null){ //select시 값이 있으면 중복구입으로 인식.
				
			
			buy_service.buy(vo); //책 구입.
			mubook_service.mybook_insert(memnum); // 책깔피
			buy_service.use_point(vo);  //사용 포인트깍기
			buy_service.point_update(vo);  //현재 금액에 대한 포인트 적립
			buy_service.sal_update(vo);  //판매량 증가
			buy_service.shop_drop(shop_vo);  //장바구니에서 삭제.
		}else{
			
			model.addAttribute("msg", "이미 구입한 물품입니다.");
		}
		
		

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.GET)
	public void total_payment(Model model, HttpSession session) throws Exception {
		//장바구니 GET방식으로 접근시.
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", buy_service.my_shop(memnum)); //장바구니 리스트
		model.addAttribute(mem_service.mem_info(memnum)); //회원 정보.

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.POST)
	public void total_buy(HttpSession session, BuyVO vo, int use_point, String p_way, int final_pay, ShopBagVO shop_vo,
			Model model) throws Exception {
		//장바구니 POST접근시 
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());

		int size = buy_service.my_shop(memnum).size();  //장바구니 안의 데이터 갯수
		int buy_size = buy_service.buy_select(memnum).size();  // 회원이 구입하는 갯수.
		
		for(int i=0 ; i<size; i++){  //장바구니안에 이미구입한 상품이 있는지 검사.
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
			buy_service.buy(vo); //책 구입.
			buy_service.sal_update(vo); //책 판매량 증가.

			mubook_service.mybook_insert(memnum); //회원 구입 책에 추가

		}

		shop_vo.setMemnum(memnum);
		buy_service.shop_drop_all(shop_vo); //회원의 전부 장바구니 삭제.
		
		vo.setFinal_pay(final_pay); 
		buy_service.use_point(vo); //포인트 사용
		buy_service.point_update(vo); // 포인트 적립.
		
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public void shop_bag(ShopBagVO shop_vo, @RequestParam("booknum") int booknum, Model model,BuyVO vo,HttpSession session) throws Exception {
		//장바구니 담을시.
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		int buy_size = buy_service.buy_select(memnum).size();
		
			for(int j=0; j<buy_size; j++){  //장바구니에 담는 상품이 구입한상품인지 검사.
				if(	buy_service.buy_select(memnum).get(j).getBooknum()  == booknum){
					
					model.addAttribute("msg", "이미 구입한 상품 입니다.");
					model.addAttribute(book_service.select(booknum));
					return;
					
				}
			}
		
		
		
		try {
			
			buy_service.shop_bag(shop_vo);
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("msg", " 장바구니에 담았습니다.");

		} catch (Exception e) {
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("msg", "이미 장바구니에 담겨있습니다..");

			

		}
	}
	
	

	@RequestMapping(value = "/shop_bag", method = RequestMethod.GET)
	public void shop_bag(Model model, HttpSession session) throws Exception {
		//장바구니 GET접근시.
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", buy_service.my_shop(memnum));

	}

	@RequestMapping(value = "/shop_drop", method = RequestMethod.GET)
	public String shop_drop(Model model, ShopBagVO vo, HttpSession session) throws Exception {
		//장바구니 삭제.
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		buy_service.shop_drop(vo);
		model.addAttribute("list", buy_service.my_shop(memnum));
		return "/products/shop_bag";

	}

}
