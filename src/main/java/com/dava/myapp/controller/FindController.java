package com.dava.myapp.controller;

import java.util.Properties;

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

import com.dava.myapp.mail.SMTPAuthenticatior;
import com.dava.myapp.service.FindPwService;

@Controller
public class FindController {
	
	@Autowired
	private FindPwService service;
	
	@RequestMapping("/member/pwsearch")
	public String findPwHandler(String id, Model model){
		System.out.println("11111");
		String from = "hyeon454";
		String to = id;
		String subject = "다봐 비밀번호 찾기";
		String content = "당신의 비밀번호는 <b>"+service.findPw(id)+"입니다";
		
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
		     
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(subject); // 제목
		     
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // 보내는 사람
		     
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		     
		    msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩
		     
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    System.out.println("전송 실패");
		}
		return "/admin/pwsearch";
	}

}