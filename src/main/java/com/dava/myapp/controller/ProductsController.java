package com.dava.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dava.myapp.service.BookService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/products/*")
public class ProductsController {
	@Inject
	private BookService service;

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String home(int booknum) throws Exception {
		service.select(booknum);
		return "/products/detail";
	}

}
