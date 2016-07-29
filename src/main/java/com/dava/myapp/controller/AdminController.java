package com.dava.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dava.myapp.domain.BookVO;
import com.dava.myapp.domain.Criteria;
import com.dava.myapp.domain.PageMaker;
import com.dava.myapp.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private AdminService service;
	
	@Inject
	private BookVO bvo;
	
	//������ �α׾ƿ�
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, HttpServletRequest req){
		session.invalidate();
		return "redirect:/";
	}
	
	// å ���
	@RequestMapping(value = "/registBook", method = RequestMethod.POST)
	public String registBook(MultipartFile img, MultipartFile hwp, Model model, HttpServletRequest req,
			String title, String genre, String author, String publisher, String pub_date, String summary, int price) throws Exception {
		bvo.setTitle(title);
		bvo.setAuthor(author);
		bvo.setGenre(genre);
		bvo.setPublisher(publisher);
		bvo.setPub_date(pub_date);
		bvo.setPrice(price);
		bvo.setSummary(summary);
		bvo.setImg(uploadFile(img.getOriginalFilename(), img.getBytes(), req.getServletContext().getRealPath("resources/covers")));
		bvo.setHwp(uploadFile(hwp.getOriginalFilename(), hwp.getBytes(), req.getServletContext().getRealPath("resources/books")));
					//Ŀ���� �� �̹��� ���ϰ� å�� ������ ���� hwp������ �����Ѵ�.
		service.registBook(bvo);

		return "redirect:/admin/listBook";
	}
	
	//������ ���ε� ���ִ� �Լ��̰� ���������� ����Ǵ� ������ �̸��� ��ȯ�Ѵ�. (å��Ͽ��� ���)
	private String uploadFile(String originalName, byte[] fileData, String path) throws IOException{
		logger.info(path);
		UUID uid = UUID.randomUUID();//���� �̸��� ������ �ö��� �ʵ��� ���ش�. ������ ���� �������ش�
		String savedName = uid.toString()+"_"+originalName;
		File target = new File(path, savedName);
		FileCopyUtils.copy(fileData, target);//������ ����
		return savedName;
	}
	
	// ��ϵ� ����
	@RequestMapping(value = "/listBook")
	public void listBook(Model model, Criteria cri) throws Exception {
		model.addAttribute("Blist", service.BooklistSearchCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.BooklistSearchCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
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
	public void listMember(Model model, Criteria cri) throws Exception {
		model.addAttribute("Mlist", service.MemberlistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.MemberlistCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
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
	public void listBuy(Model model, Criteria cri) throws Exception {
		System.out.println(service.BuylistCriteria(cri).get(0).getTitle());
		model.addAttribute("Buylist", service.BuylistCriteria(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.BuylistCountCriteria(cri));
		
		model.addAttribute("pageMaker", pageMaker);
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
			service.deleteMy(Integer.parseInt(chBuy[i]));
		}
		return "redirect:/admin/listBuy";
	}

	/*
	// paging
	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listBook(Criteria cri, Model model) throws Exception {
		logger.info("show list");
		model.addAttribute("list", service.listCriteria(cri));
	}*/
}