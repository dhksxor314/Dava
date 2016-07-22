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

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReadBookController {

	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest req) {
		String path = req.getServletContext().getRealPath("resources");
		
		String title = "�޺�������1";
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

		model.addAttribute("totalPage", totalPage);
		//model.addAttribute("markedPage", markedPage);
		model.addAttribute("content", content);
		
		return "/readbook/readbook";
	}
	
	@RequestMapping(value = "/readbook/setmark", method = RequestMethod.GET)
	public void markHandler(@RequestParam("page-number") int num){
		
	}
	


	
}
