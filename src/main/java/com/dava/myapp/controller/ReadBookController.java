/*
 * ���� : å �д� �������� �̵��ϸ鼭 �ش� å�� �´� å ������ �ҷ��´�.
 * �ۼ��� : ������
 */

package com.dava.myapp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.dava.myapp.service.MyBookService;


@Controller
public class ReadBookController {
	
	@Autowired
	private MyBookService service;
	
	
	//������ å���� ���⸦ �������� �ÿ� å�� �����ֱ� ���� ������ ���� �ڵ鷯
	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(@RequestParam("mybooknum") int mybooknum, HttpServletRequest req, Model model) {
		
		int startPage=1;
		
		if(service.getBookmark(mybooknum)!=1){
			startPage=service.getBookmark(mybooknum);
		}

		String path = req.getServletContext().getRealPath("resources");

		String title = service.getTitle(mybooknum);
		int pageCutline=30;//�� �������� ���� ��
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		BufferedReader br=null;
		
		try {
			br=new BufferedReader(new FileReader(new File(path+"\\books\\"+title+".txt")));
			String a="";
			
			while(br.readLine()!=null){//å �ѱ��� �� ���� ���� ���� ���Ѵ�.  
				totalLine++;
			}
			
			totalPage=(int)Math.ceil(((double)totalLine/(double)pageCutline));//�ø� �Լ��� �Ἥ �� �������� ����
			
			content=new String[totalPage];//content�迭�� ������ �� ��ŭ �ʱ�ȭ�ϱ� ���ؼ�
			for(int i=0;i<totalPage;i++){//�� �۾��� ���� �� ù���ڿ� null�� ��
				content[i]="";
			}
			
			br=new BufferedReader(new FileReader(new File(path+"\\books\\"+title+".txt")));//�ٽ� å�� �ҷ��´�.
			int cnt=0;//������ ��ȣ
			int line=1;//pageCutline�� ���߱� ���ؼ� ���

			while((a=br.readLine())!=null){//30������ 1�������� ��� �����͸� �־��ش�.
				content[cnt]+=a+"<br/>";
				if(line==pageCutline){line=1;cnt++;}
				else{line++;}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�");
		} catch (IOException e) {
			System.out.println("����� ����");
		} finally {		
			try {br.close();} catch (IOException e) {e.printStackTrace();}
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
