package com.dava.myapp.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import com.dava.myapp.service.AdminService;

@Controller
@RequestMapping("/admin/*")
public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private AdminService service;
	
	@Inject
	private BookVO bvo;
	
	// 책 등록
	@RequestMapping(value = "/registBook", method = RequestMethod.POST)
	public String registBook(MultipartFile img, MultipartFile hwp, Model model, HttpServletRequest req,
			String title, String genre, String author, String publisher, String pub_date, String summary, int price) throws Exception {
		bvo.setTitle(title);
		bvo.setAuthor(author);
		bvo.setGenre(genre);
		bvo.setPublisher(publisher);
		bvo.setPub_date(pub_date);
		bvo.setSummary(summary);
		bvo.setImg(uploadFile(img.getOriginalFilename(), img.getBytes(), req.getServletContext().getRealPath("resources/covers")));
		bvo.setHwp(uploadFile(hwp.getOriginalFilename(), hwp.getBytes(), req.getServletContext().getRealPath("resources/books")));
					//커버로 쓸 이미지 파일과 책의 내용을 가진 hwp파일을 저장한다.
		service.registBook(bvo);

		return "redirect:/admin/listBook";
	}
	
	//파일을 업로드 해주는 함수이고 최종적으로 저장되는 파일의 이름을 반환한다.
	private String uploadFile(String originalName, byte[] fileData, String path) throws IOException{
		UUID uid = UUID.randomUUID();//같은 이름의 파일이 올라가지 않도록 해준다. 고유한 값을 생성해준다
		String savedName = uid.toString()+"_"+originalName;
		File target = new File(path, savedName);
		FileCopyUtils.copy(fileData, target);
		return savedName;
	}
	
	// 등록된 도서
	@RequestMapping(value = "/listBook")
	public String listBook(Model model) throws Exception {
		model.addAttribute("Blist", service.listBook());
		return "/admin/listBook";
	}
	// 도서 정보 확인
	@RequestMapping(value = "/readBook")
	public String readP(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
		return "/admin/readBook";
	}
	// 구매내역에서 도서정보를 확인만 가능 하도록
	@RequestMapping(value = "/readBookBuy")
	public void readBookBuy(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}
	// 도서 정보 수정
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public void updateG(Model model, @RequestParam("booknum") int booknum) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}
	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateP(BookVO bvo) throws Exception {
		service.updateBook(bvo);
		return "redirect:/admin/listBook";
	}
	// 도서 삭제
	@RequestMapping(value = "/deleteBook")
	public String deleteBook(HttpServletRequest req) throws Exception {
		String[] chBook = req.getParameterValues("chBook");
		for (int i = 0; i < chBook.length; i++) {
			service.deleteBook(Integer.parseInt(chBook[i]));
		}
		return "redirect:/admin/listBook";
	}

	
	// 회원 리스트
	@RequestMapping(value = "/listMember")
	public String listMember(Model model) throws Exception {
		model.addAttribute("Mlist", service.listMember());
		return "/admin/listMember";
	}
	// 회원 삭제
	@RequestMapping(value = "/deleteMember")
	public String deleteMember(HttpServletRequest req) throws Exception {
		String[] chMember = req.getParameterValues("chMember");
		for (int i = 0; i < chMember.length; i++) {
			System.out.println("test: " + Integer.parseInt(chMember[i]));
			service.deleteMember(Integer.parseInt(chMember[i]));
		}
		return "redirect:/admin/listMember";
	}
	// Buy에서 회원 정보 확인만 하도록
	@RequestMapping(value = "/readMember")
	public void readMember(Model model, @RequestParam("memnum") int memnum) throws Exception {
		model.addAttribute(service.readMember(memnum));
	}
	
	
	
	// 구매 리스트
	@RequestMapping(value = "/listBuy")
	public String listBuy(Model model) throws Exception {
		model.addAttribute("Buylist", service.listBuy());
		return "/admin/listBuy";
	}
	// 구매 정보
	@RequestMapping(value = "/readBuy")
	public void readBuy(Model model, @RequestParam("buynum") int buynum) throws Exception {
		model.addAttribute(service.readBuy(buynum));
	}
	// 구매 삭제(환불)
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