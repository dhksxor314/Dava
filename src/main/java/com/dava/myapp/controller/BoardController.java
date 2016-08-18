/*
 * ���� : å �д� �������� �̵��ϸ鼭 �ش� å�� �´� å ������ �ҷ��´�.
 * �ۼ��� : ������
 */

package com.dava.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dava.myapp.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public void list(Model model){
		System.out.println(service.list().size());
		model.addAttribute("list", service.list());
	}
}
