package com.dava.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.service.BuyService;
import com.dava.myapp.service.MemberService;

@Controller
@RequestMapping("/mypage/*")
public class MypageController {
	@Inject
	private BuyService Buy_service;
	@Inject
	private MemberService mem_service;

	@RequestMapping(value = "/mypage_main", method = RequestMethod.GET)
	public String mypage_main() throws Exception {
		return "/mypage/mypage_main";
	}

	@RequestMapping(value = "/mypage_Buybook", method = RequestMethod.GET)
	public String mypage_buybook(HttpSession session, Model model) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		model.addAttribute("list", Buy_service.mypage_buy(memnum));

		return "/mypage/mypage_Buybook";
	}

	@RequestMapping(value = "/mypage_personal_info", method = RequestMethod.GET)
	public String mypage_personal_info(Model model) throws Exception {
		model.addAttribute("get", "get");
		return "/mypage/mypage_personal_info";
	}

	@RequestMapping(value = "/mypage_personal_info", method = RequestMethod.POST)
	public String mypage_personal_info_POST(@RequestParam("nowpassword") String nowpassword,
			@RequestParam("editpassword") String editpassword,
			@RequestParam("editpassword_check") String editpassword_check, HttpSession session, Model model,
			MemberVO vo) throws Exception {
		int memnum = Integer.parseInt(session.getAttribute("memnum").toString());
		if (nowpassword.equals("") || editpassword.equals("") || editpassword_check.equals("")) {
			model.addAttribute("nowpassword", nowpassword);
			model.addAttribute("msg", "�����͸� ���� �Է��� �ּ���.");
		} else {
			if (!nowpassword.equals(mem_service.mem_info(memnum).getPassword())) {
				model.addAttribute("msg", "�����й�ȣ�� �ٸ��ϴ�.");
			} else {
				if (!editpassword.equals(editpassword_check)) {
					model.addAttribute("nowpassword", nowpassword);
					model.addAttribute("msg", "������ ��й�ȣ�� Ȯ�����ּ���");
				} else {
					vo.setPassword(editpassword);
					vo.setmemnum(memnum);
					mem_service.editpassword(vo);
					model.addAttribute("nowpassword", nowpassword);
					model.addAttribute("editpassword", editpassword);
					model.addAttribute("msg", "��й�ȣ�� ����Ǿ����ϴ�");
				}
			}
		}

		return "/mypage/mypage_personal_info";
	}

}
