/*
 * ���� : å �д� �������� �̵��ϸ鼭 �ش� å�� �´� å ������ �ҷ��´�.
 * �ۼ��� : ������
 */

package com.dava.myapp.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.argo.hwp.HwpTextExtractor;
import com.dava.myapp.service.MyBookService;


@Controller
public class ReadBookController {
	
	@Autowired
	private MyBookService service;
	
	
	//������ å���� ���⸦ �������� �ÿ� å�� �����ֱ� ���� ������ ���� �ڵ鷯
	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(@RequestParam("mybooknum") int mybooknum, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {
		
		int startPage=1;
		
		if(service.getBookmark(mybooknum)!=1){
			startPage=service.getBookmark(mybooknum);
		}

		String path = req.getServletContext().getRealPath("resources");

		String title = service.getTitle(mybooknum);
		int pageCutline=25;//�� �������� ���� ��
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		
		File hwp = new File(path+"\\books\\"+title+".hwp"); // �ؽ�Ʈ�� ������ HWP ����
	    Writer writer = new StringWriter(); // ����� �ؽ�Ʈ�� ����� ����
	    HwpTextExtractor.extract(hwp, writer); // ���Ϸκ��� �ؽ�Ʈ ����
	    String text = writer.toString(); // ����� �ؽ�Ʈ
	    String c="";
	    int cnt=1;
	    for(int i=1;i<=text.length();i++){
	    	c+=text.charAt(i-1);
	    	if(text.charAt(i-1)=='\n'){
	    		c+='\n';
	    		cnt=1;
	    	}
	    	else{
	    		cnt++;
	    	}
		    if(cnt%40==0){c+="\n";}	    	
	    }
	    
	    String cline[] = c.split("\n");
	    totalLine=cline.length;
	    totalPage=(int)Math.ceil(((double)totalLine/(double)pageCutline));
	    content = new String[totalPage];

	    for(int i=0;i<totalPage;i++){
	    	content[i]="";
	    }
	    
	    int j=0;
	    for(int i=0;i<totalLine;i++){
	    	content[j]+=cline[i]+"<br/>";
	    	if(((i+1)%pageCutline)==0){j++;}
	    }
	    		
		model.addAttribute("img", service.getImage(mybooknum));
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("content", content);
		
		return "/readbook/readbook";
		
	}
	
	
	//å���� ����� ó���ϴ� �ڵ鷯
	@RequestMapping(value = "/readbook/setmark", method = RequestMethod.POST)
	public String markHandler(@RequestParam("page_number") int page_number, @RequestParam("mybooknum") int mybooknum, Model model){
		
		model.addAttribute("mybooknum", mybooknum);
		service.setBookmark(page_number, mybooknum);
		return "redirect:/readbook/read";
	}
	


	
}
