package com.dava.myapp.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dava.myapp.domain.PageMaker;
import com.dava.myapp.domain.SearchCriteria;
import com.dava.myapp.service.AdminService;


@Controller
@RequestMapping("/admin/*")
public class SearchBoardController {

  private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);

  @Inject
  private AdminService service;

  @RequestMapping(value = "/listBook", method = RequestMethod.GET)
  public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    logger.info(cri.toString());

    //model.addAttribute("Blist", service.BooklistCriteria(cri));
    model.addAttribute("Blist", service.BooklistSearchCriteria(cri));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);

    //pageMaker.setTotalCount(service.BooklistCountCriteria(cri));
    pageMaker.setTotalCount(service.BooklistSearchCount(cri));

    model.addAttribute("pageMaker", pageMaker);
  }
  
  @RequestMapping(value = "/listMember", method = RequestMethod.GET)
  public void listMember(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    logger.info(cri.toString());

    //model.addAttribute("Mlist", service.MemberlistCriteria(cri));
    model.addAttribute("Mlist", service.MemberlistSearchCriteria(cri));

    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);

    //pageMaker.setTotalCount(service.MemberlistCountCriteria(cri));
    pageMaker.setTotalCount(service.MemberlistSearchCount(cri));

    model.addAttribute("pageMaker", pageMaker);
  }
  
  @RequestMapping(value = "/listBuy", method = RequestMethod.GET)
  public void listBuy(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
  
    	try {
    	    model.addAttribute("Buylist", service.BuylistSearchCriteria(cri));
    	    PageMaker pageMaker = new PageMaker();
    	    pageMaker.setCri(cri);
    	    pageMaker.setTotalCount(service.BuylistSearchCount(cri));

    	    model.addAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			// TODO: handle exception
			
			
		}

  }
}
