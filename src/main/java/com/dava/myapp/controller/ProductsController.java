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
		//å ����

		try {
			model.addAttribute(book_service.select(booknum)); //�Ͽ����� ����.
			model.addAttribute(buy_service.bag_select(shop_vo)); // �̹� ������ ��ǰ���� �˻�.
			model.addAttribute("check", false); //�����Ѱ����� �ƴ��� model�� ������.
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("check", true);
		}

	}
	
	
	

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void payment(@RequestParam("booknum") int booknum, @RequestParam("memnum") int memnum, Model model)
			throws Exception {
		//GET������� ���ٽ� ���� �������� ������ �̵�.

		model.addAttribute(book_service.select(booknum)); //å������ ���� 
		model.addAttribute(mem_service.mem_info(memnum)); //ȸ�� ����
	}

	
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	public void buy(BuyVO vo, Model model,ShopBagVO shop_vo, HttpSession session) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
			//POST������� ���ٽ�. ����. 
		
		
		if( buy_service.buycheck(vo) == null){ //select�� ���� ������ �ߺ��������� �ν�.
				
			
			buy_service.buy(vo); //å ����.
			mubook_service.mybook_insert(memnum); // å����
			buy_service.use_point(vo);  //��� ����Ʈ���
			buy_service.point_update(vo);  //���� �ݾ׿� ���� ����Ʈ ����
			buy_service.sal_update(vo);  //�Ǹŷ� ����
			buy_service.shop_drop(shop_vo);  //��ٱ��Ͽ��� ����.
		}else{
			
			model.addAttribute("msg", "�̹� ������ ��ǰ�Դϴ�.");
		}
		
		

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.GET)
	public void total_payment(Model model, HttpSession session) throws Exception {
		//��ٱ��� GET������� ���ٽ�.
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", buy_service.my_shop(memnum)); //��ٱ��� ����Ʈ
		model.addAttribute(mem_service.mem_info(memnum)); //ȸ�� ����.

	}

	@RequestMapping(value = "/total_payment", method = RequestMethod.POST)
	public void total_buy(HttpSession session, BuyVO vo, int use_point, String p_way, int final_pay, ShopBagVO shop_vo,
			Model model) throws Exception {
		//��ٱ��� POST���ٽ� 
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());

		int size = buy_service.my_shop(memnum).size();  //��ٱ��� ���� ������ ����
		int buy_size = buy_service.buy_select(memnum).size();  // ȸ���� �����ϴ� ����.
		
		for(int i=0 ; i<size; i++){  //��ٱ��Ͼȿ� �̹̱����� ��ǰ�� �ִ��� �˻�.
			for(int j=0; j<buy_size; j++){
				if(	buy_service.my_shop(memnum).get(i).getBooknum() == buy_service.buy_select(memnum).get(j).getBooknum()){
					
					model.addAttribute("msg", "�����Ͻ� ��ǰ�� �̹� �������Դϴ� \\n �������������� Ȯ���� �ּ���.");
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
			buy_service.buy(vo); //å ����.
			buy_service.sal_update(vo); //å �Ǹŷ� ����.

			mubook_service.mybook_insert(memnum); //ȸ�� ���� å�� �߰�

		}

		shop_vo.setMemnum(memnum);
		buy_service.shop_drop_all(shop_vo); //ȸ���� ���� ��ٱ��� ����.
		
		vo.setFinal_pay(final_pay); 
		buy_service.use_point(vo); //����Ʈ ���
		buy_service.point_update(vo); // ����Ʈ ����.
		
	}

	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public void shop_bag(ShopBagVO shop_vo, @RequestParam("booknum") int booknum, Model model,BuyVO vo,HttpSession session) throws Exception {
		//��ٱ��� ������.
		
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		int buy_size = buy_service.buy_select(memnum).size();
		
			for(int j=0; j<buy_size; j++){  //��ٱ��Ͽ� ��� ��ǰ�� �����ѻ�ǰ���� �˻�.
				if(	buy_service.buy_select(memnum).get(j).getBooknum()  == booknum){
					
					model.addAttribute("msg", "�̹� ������ ��ǰ �Դϴ�.");
					model.addAttribute(book_service.select(booknum));
					return;
					
				}
			}
		
		
		
		try {
			
			buy_service.shop_bag(shop_vo);
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("msg", " ��ٱ��Ͽ� ��ҽ��ϴ�.");

		} catch (Exception e) {
			model.addAttribute(book_service.select(booknum));
			model.addAttribute("msg", "�̹� ��ٱ��Ͽ� ����ֽ��ϴ�..");

			

		}
	}
	
	

	@RequestMapping(value = "/shop_bag", method = RequestMethod.GET)
	public void shop_bag(Model model, HttpSession session) throws Exception {
		//��ٱ��� GET���ٽ�.
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", buy_service.my_shop(memnum));

	}

	@RequestMapping(value = "/shop_drop", method = RequestMethod.GET)
	public String shop_drop(Model model, ShopBagVO vo, HttpSession session) throws Exception {
		//��ٱ��� ����.
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		buy_service.shop_drop(vo);
		model.addAttribute("list", buy_service.my_shop(memnum));
		return "/products/shop_bag";

	}

}
