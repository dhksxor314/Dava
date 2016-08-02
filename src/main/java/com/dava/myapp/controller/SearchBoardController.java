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
    System.out.println(service.BuylistSearchCriteria(cri).get(0).getTitle());

    model.addAttribute("Buylist", service.BuylistSearchCriteria(cri));
    PageMaker pageMaker = new PageMaker();
    pageMaker.setCri(cri);
    pageMaker.setTotalCount(service.BuylistSearchCount(cri));

    model.addAttribute("pageMaker", pageMaker);
  }
  
/*
  @RequestMapping(value = "/readBook", method = RequestMethod.GET)
  public void read(@RequestParam("booknum") int booknum, @ModelAttribute("cri") SearchCriteria cri, Model model)
      throws Exception {

    model.addAttribute(service.readBook(booknum));
  }

  @RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
  public String remove(@RequestParam("booknum") int booknum, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    service.deleteBook(booknum);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addAttribute("searchType", cri.getSearchType());
    rttr.addAttribute("keyword", cri.getKeyword());

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/sboard/list";
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
  public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {

    model.addAttribute(service.readBook(bno));
  }

  @RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
  public String modifyPagingPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

    logger.info(cri.toString());
    service.modify(board);

    rttr.addAttribute("page", cri.getPage());
    rttr.addAttribute("perPageNum", cri.getPerPageNum());
    rttr.addAttribute("searchType", cri.getSearchType());
    rttr.addAttribute("keyword", cri.getKeyword());

    rttr.addFlashAttribute("msg", "SUCCESS");

    logger.info(rttr.toString());

    return "redirect:/sboard/list";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void registGET() throws Exception {

    logger.info("regist get ...........");
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

    logger.info("regist post ...........");
    logger.info(board.toString());

    service.regist(board);

    rttr.addFlashAttribute("msg", "SUCCESS");

    return "redirect:/sboard/list";
  }

  // @RequestMapping(value = "/list", method = RequestMethod.GET)
  // public void listPage(@ModelAttribute("cri") SearchCriteria cri,
  // Model model) throws Exception {
  //
  // logger.info(cri.toString());
  //
  // model.addAttribute("list", service.listCriteria(cri));
  //
  // PageMaker pageMaker = new PageMaker();
  // pageMaker.setCri(cri);
  //
  // pageMaker.setTotalCount(service.listCountCriteria(cri));
  //
  // model.addAttribute("pageMaker", pageMaker);
  // }
   */
   
}
