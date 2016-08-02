package com.dava.myapp.controller;

import java.util.Properties;
import java.util.Random;

import javax.inject.Inject;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dava.myapp.domain.MemberVO;
import com.dava.myapp.mail.SMTPAuthenticatior;
import com.dava.myapp.service.FindPwService;
import com.dava.myapp.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
   @Inject
   private MemberService mem_service;

   @Autowired
 	private FindPwService service;
   
   

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
   
   @RequestMapping(value = "/pwsearch", method = RequestMethod.GET)
   public String pwsearch_GET() throws Exception {

      return "/member/pwsearch";
   }
   
   @RequestMapping(value = "/pwsearch", method = RequestMethod.POST)
   public String pwsearch_POST(@RequestParam("id") String id, Model model) throws Exception {
	   
	   String input = mem_service.pwsearch(id).getPassword();
	   
	   if(input == null){
		   model.addAttribute("msg","��ϵ������� ���̵��Դϴ�.");
	   }else{
		   model.addAttribute("msg","��ϵ� �ƾƵ�  �Դϴ�.<br><a href='/member/findPw?id="+id+"' id='check'>��й�ȣ�� �̸��Ϸ� �����÷��� ���⸦ Ŭ���ϼ���</a>");
		   
		   model.addAttribute("id", id);
	   }
	   
      return "/member/pwsearch";
   }
   
 
	
	@RequestMapping("/findPw")
	public String findPwHandler(String id, Model model,	MemberVO vo) throws Exception{
		Random random = new Random();
		int rand =random.nextInt(9000)+1000;
		
		
		System.out.println(id);
		
		int memnum = mem_service.pwsearch(id).getmemnum();
		System.out.println(memnum);
		vo.setmemnum(memnum);
		vo.setPassword(rand+"");
		mem_service.editpassword(vo);
		
		
		
		String from = "hyeon454";
		String to = id;
		String subject = "�ٺ� ��й�ȣ ã��";
		String content = "����� ��й�ȣ�� <b>"+rand+"�� ����Ǿ����ϴ�. <br/>��й�ȣ�� ������ �ּ���.";
		
		try{
			
			Properties p = new Properties();
			p.put("mail.smtp.host", "smtp.naver.com");
			p.put("mail.smtp.port", "465");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.debug", "true");
			p.put("mail.smtp.socketFactory.port", "465");
			p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			p.put("mail.smtp.socketFactory.fallback", "false");
		    Authenticator auth = new SMTPAuthenticatior();
		    Session ses = Session.getInstance(p, auth);
		     
		    ses.setDebug(true);
		    MimeMessage msg = new MimeMessage(ses); // ������ ������ ���� ��ü
		    msg.setSubject(subject); // ����
		    
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // ������ ���

		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // �޴� ���

		    msg.setContent(content, "text/html;charset=UTF-8"); // ����� ���ڵ�

		    Transport.send(msg); // ����
		} catch(Exception e){
		    System.out.println("���� ����");
		}
		return "/member/pwsearch";
	}

   


}