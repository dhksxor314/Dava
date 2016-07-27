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
         model.addAttribute("msg", "데이터를 전부 입력해 주세요.");
      } else {
         if (password.equals(password_check)) {
            try {
               mem_service.join(vo);
               model.addAttribute("msg", "회원가입에 성공하셨습니다.");
               model.addAttribute("close", "close");
            } catch (Exception e) {
               // TODO: handle exception

               model.addAttribute("msg", "중복된 이메일이 있습니다.");
               model.addAttribute("nickname", nickname);
            }
         } else {

            model.addAttribute("id", id);
            model.addAttribute("nickname", nickname);
            model.addAttribute("msg", "패스워드를 확인해 주세요.");
         }

      }

      //

      return "/member/join";
   }

   


}