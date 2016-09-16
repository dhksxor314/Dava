package com.dava.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.service.BookService;
import com.dava.myapp.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Inject
	private BookService book_service;
	@Inject
	private MemberService mem_service;
	@Inject
	private BookService service;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {

		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("list", book_service.issue());
		model.addAttribute("newstlist", book_service.newstbook());
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(MemberVO vo, Model model,HttpSession session) throws Exception {
		
		
		try {
			String nickname = mem_service.login(vo).getNickname();
			int memnum = mem_service.login(vo).getmemnum();
			
			session.setAttribute("nickname", nickname);
			session.setAttribute("memnum", memnum);
			if(mem_service.login(vo).getId().equals("admin@dava.com")){
				return "redirect:/admin/listBook";
			}

		} catch (Exception e) {
			// TODO: handle exception
			
			model.addAttribute("msg", "아이디 혹은 비밀번호를 확인해 주세요");
		}
		
		model.addAttribute("list", book_service.issue());
		model.addAttribute("newstlist", book_service.newstbook());
		return "home";
	}

	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,HttpSession session) throws Exception {
		session.removeAttribute("nickname");
		session.removeAttribute("memnum");
		model.addAttribute("list", book_service.issue());
		model.addAttribute("newstlist", book_service.newstbook());
		return "home";
	}
	
	

	
}
