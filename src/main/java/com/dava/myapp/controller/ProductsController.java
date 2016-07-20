package com.dava.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public void detail(@RequestParam("booknum") int booknum,Model model ) throws Exception {

	    model.addAttribute(service.select(booknum));
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public void payment(@RequestParam("booknum") int booknum,Model model ) throws Exception {

	    model.addAttribute(service.select(booknum));
	}
	


}
