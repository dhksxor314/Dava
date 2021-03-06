/*
 * 설명 : 관리자가 하는 작업(도서등록 및 삭제, 회원관리)들을 모아둔 컨트롤러
 * 작성자 : 전현영
 * 작성부분 : 도서 등록 및 삭제(파일까지)
 * 
 */

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	// 관리자 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(HttpSession session, HttpServletRequest req) {
		session.invalidate();
		return "redirect:/";
	}

	// 책 등록
	@RequestMapping(value = "/registBook", method = RequestMethod.POST)
	public String registBook(MultipartFile img, MultipartFile hwp, Model model, HttpServletRequest req, String title,
			String genre, String author, String publisher, String pub_date, String summary, int price)
			throws Exception {
		
		bvo.setTitle(title);
		bvo.setAuthor(author);
		bvo.setGenre(genre);
		bvo.setPublisher(publisher);
		bvo.setPub_date(pub_date);
		bvo.setPrice(price);
		bvo.setSummary(summary);
		bvo.setImg(uploadFile(img.getOriginalFilename(), img.getBytes(),
				req.getServletContext().getRealPath("resources/covers")));
		bvo.setHwp(uploadFile(hwp.getOriginalFilename(), hwp.getBytes(),
				req.getServletContext().getRealPath("resources/books")));
		// 커버로 쓸 이미지 파일과 책의 내용을 가진 hwp파일을 저장한다.
		service.registBook(bvo);

		return "redirect:/admin/listBook";
	}

	// 파일을 업로드 해주는 함수이고 최종적으로 저장되는 파일의 이름을 반환한다. (책등록에서 사용)
	private String uploadFile(String originalName, byte[] fileData, String path) throws IOException {
		logger.info(path);
		UUID uid = UUID.randomUUID();// 같은 이름의 파일이 올라가지 않도록 해준다. 고유한 값을 생성해준다
		String savedName = uid.toString() + "_" + originalName;
		File target = new File(path, savedName);
		FileCopyUtils.copy(fileData, target);// 파일을 저장
		return savedName;
	}

	// 도서 삭제
	@RequestMapping(value = "/deleteBook", method=RequestMethod.POST)
	public String deleteBook(HttpServletRequest req) throws Exception {
		String[] chBook = req.getParameterValues("chBook");

		String bookpath = req.getServletContext().getRealPath("resources/books");//경로를 가져오고
		String coverpath = req.getServletContext().getRealPath("resources/covers");
		for (int i = 0; i < chBook.length; i++) {//선택된 책의 파일을 모두 삭제
			logger.info(service.readBook(Integer.parseInt(chBook[i])).getHwp());
			deleteFile(bookpath + "/" + service.readBook(Integer.parseInt(chBook[i])).getHwp(),
					coverpath + "/" + service.readBook(Integer.parseInt(chBook[i])).getImg());
			//
			service.deleteBook(Integer.parseInt(chBook[i]));//파일을 삭제한 후에 디비를 삭제
		}

		return "redirect:/admin/listBook";
	}

	// 등록된 도서를 삭제할 시에 업로드된 파일들을 삭제한다.
	private void deleteFile(String bookpath, String coverpath) {
		File bookdel = new File(bookpath);
		File coverdel = new File(coverpath);
		if (bookdel.exists()) {//파일이 존재할 경우 삭제
			bookdel.delete();
		}
		if (coverdel.exists()) {
			coverdel.delete();
		}
	}

	// 도서 정보 확인
	@RequestMapping(value = "/readBook")
	public void readBook(Model model, @RequestParam("booknum") int booknum, @ModelAttribute("cri") Criteria cri)
			throws Exception {
		model.addAttribute(service.readBook(booknum));
	}

	// 구매내역에서 도서정보를 확인만 가능 하도록
	@RequestMapping(value = "/readBookBuy")
	public void readBookBuy(Model model, @RequestParam("booknum") int booknum, @ModelAttribute("cri") Criteria cri) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}

	// 도서 정보 수정
	@RequestMapping(value = "/updateBook", method = RequestMethod.GET)
	public void updateG(Model model, @RequestParam("booknum") int booknum, @ModelAttribute("cri") Criteria cri) throws Exception {
		model.addAttribute(service.readBook(booknum));
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public String updateP(BookVO bvo, Criteria cri, RedirectAttributes rttr) throws Exception {
		service.updateBook(bvo);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/listBook";
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
	public void readMember(Model model, @RequestParam("memnum") int memnum, @ModelAttribute("cri")Criteria cri) throws Exception {
		model.addAttribute(service.readMember(memnum));
	}



}