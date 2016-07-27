package com.dava.myapp.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
   @Inject
   private MemberService mem_service;

   

   @RequestMapping(value = "/join", method = RequestMethod.GET)
   public String joinGET(Model model) throws Exception {
      model.addAttribute("get", "get");
      return "/member/join";
   }

   @RequestMapping(value = "/join", method = RequestMethod.POST)
   public String joinPOST(MemberVO vo, Model model) throws Exception {

      String id = vo.getId();
      String nickname = vo.getNickname();
      String password = vo.getPassword();
      String password_check = vo.getPassword_check();


      if (id.equals("") || nickname.equals("") || password.equals("") || password_check.equals("")) {
         model.addAttribute("id", id);
         model.addAttribute("nickname", nickname);
         model.addAttribute("msg", "�����͸� ���� �Է��� �ּ���.");
      } else {
         if (password.equals(password_check)) {
            try {
               mem_service.join(vo);
               model.addAttribute("msg", "ȸ�����Կ� �����ϼ̽��ϴ�.");
               model.addAttribute("close", "close");
            } catch (Exception e) {
               // TODO: handle exception

               model.addAttribute("msg", "�ߺ��� �̸����� �ֽ��ϴ�.");
               model.addAttribute("nickname", nickname);
            }
         } else {

            model.addAttribute("id", id);
            model.addAttribute("nickname", nickname);
            model.addAttribute("msg", "�н����带 Ȯ���� �ּ���.");
         }

      }

      //

      return "/member/join";
   }

   


}