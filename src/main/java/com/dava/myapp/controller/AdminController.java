package com.dava.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private AdminService service;

	// å ���
	@RequestMapping(value = "/registBook", method = RequestMethod.POST)
	public String registBook(BookVO bvo, HttpServletRequest req) throws Exception {
		service.registBook(bvo);

		return "redirect:/admin/listBook";
	}
	// ��ϵ� ����
	@RequestMapping(value = "/listBook")
	public String listBook(Model model) throws Exception {
		model.addAttribute("Blist", service.listBook());
		return "/admin/listBook";
	}
	// ���� ���� Ȯ��
	@RequestMapping(value = "/readBook")
	public String readP(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
		return "/admin/readBook";
	}
	// ���ų������� ���������� Ȯ�θ� ���� �ϵ���
	@RequestMapping(value = "/readBookBuy")
	public void readBookBuy(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}
	// ���� ���� ����
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public void updateG(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateP(BookVO bvo) throws Exception {
		service.updateBook(bvo);
		return "redirect:/admin/listBook";
	}
	// ���� ����
	@RequestMapping(value = "/deleteBook")
	public String deleteBook(HttpServletRequest req) throws Exception {
		String[] chBook = req.getParameterValues("chBook");
		for (int i = 0; i < chBook.length; i++) {
			service.deleteBook(Integer.parseInt(chBook[i]));
		}
		return "redirect:/admin/listBook";
	}

	
	// ȸ�� ����Ʈ
	@RequestMapping(value = "/listMember")
	public String listMember(Model model) throws Exception {
		model.addAttribute("Mlist", service.listMember());
		return "/admin/listMember";
	}
	// ȸ�� ����
	@RequestMapping(value = "/deleteMember")
	public String deleteMember(HttpServletRequest req) throws Exception {
		String[] chMember = req.getParameterValues("chMember");
		for (int i = 0; i < chMember.length; i++) {
			System.out.println("test: " + Integer.parseInt(chMember[i]));
			service.deleteMember(Integer.parseInt(chMember[i]));
		}
		return "redirect:/admin/listMember";
	}
	// Buy���� ȸ�� ���� Ȯ�θ� �ϵ���
	@RequestMapping(value = "/readMember")
	public void readMember(Model model, @RequestParam("memnum") int memnum) throws Exception {
		model.addAttribute(service.readMember(memnum));
	}
	
	
	
	// ���� ����Ʈ
	@RequestMapping(value = "/listBuy")
	public String listBuy(Model model) throws Exception {
		model.addAttribute("Buylist", service.listBuy());
		return "/admin/listBuy";
	}
	// ���� ����
	@RequestMapping(value = "/readBuy")
	public void readBuy(Model model, @RequestParam("buynum") int buynum) throws Exception {
		model.addAttribute(service.readBuy(buynum));
	}
	// ���� ����(ȯ��)
	@RequestMapping(value = "/deleteBuy")
	public String deleteBuy(HttpServletRequest req) throws Exception {
		String[] chBuy = req.getParameterValues("chBuy");
		for (int i = 0; i < chBuy.length; i++) {
			service.deleteBuy(Integer.parseInt(chBuy[i]));
		}
		return "redirect:/admin/listBuy";
	}

	
	// paging
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listBook(Criteria cri, Model model) throws Exception {
		logger.info("show list");
		model.addAttribute("list", service.listCriteria(cri));
	}
}