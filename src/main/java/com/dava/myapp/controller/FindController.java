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
		String subject = "�ٺ� ��й�ȣ ã��";
		String content = "����� ��й�ȣ�� <b>"+service.findPw(id)+"�Դϴ�";
		
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
		return "/admin/pwsearch";
	}

}