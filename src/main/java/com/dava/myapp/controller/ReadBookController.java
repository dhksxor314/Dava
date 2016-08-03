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
	@RequestMapping(value = "/readbook/read", method = RequestMethod.POST)
	public String home(@RequestParam("mybooknum") int mybooknum, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {

		int startPage=service.getBookmark(mybooknum);//å���⸦ ������ �� �⺻ ������������ 1�̸� å���ǰ� ��ϵ� ��쿡�� å���ǿ� ��ϵ� 
									
		String path = req.getServletContext().getRealPath("resources/books");//å�� ����Ǿ� �ִ� ������ ��θ� ����

		String title = service.getHwp(mybooknum);//��� ����� å�� hwp������ �̸��� �����´�

		int pagePerLine=25;//�� �������� ���� ��
		int charPerLine=40;//
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		
		File hwp = new File(path+"\\"+title); // �ؽ�Ʈ�� ������ HWP ����
	    Writer writer = new StringWriter(); // ����� �ؽ�Ʈ�� ����� ����
	    HwpTextExtractor.extract(hwp, writer); // ���Ϸκ��� �ؽ�Ʈ ����
	    String text = writer.toString(); // ����� �ؽ�Ʈ
	    String c="";//�Ʒ��� �˰������� ������� �ؽ�Ʈ�� ������ ����
	    int cnt=0;//�� ���ο� ������� ������ ���� ���� ����
	    for(int i=1;i<=text.length();i++){//charPerLine(�Ѷ����� ����)�� �Ѵ� ���ܿ� \n�� �����Ѵ�. \n�� �������� ������ �и��Ұ��̱⶧��
	    	c+=text.charAt(i-1);
	    	if(text.charAt(i-1)=='\n'){//������ ������ �κп� \n�� �����ϰ� �Ѷ��ο� ���� ���ڼ��� 0���� ������.
	    		c+='\n';
	    		cnt=0;
	    	}
	    	else{	    		
	    		cnt++;
	    	}
		    if(cnt%charPerLine==0){c+="\n";cnt=0;}//�Ѷ��ο� 40���ڰ� ä������ �� \n�� �����ϰ� cnt�� 0���� �ʱ�ȭ	
	    }
	    
	    String cline[] = c.split("\n");//������ \n�� ������ ���� �̿��Ͽ� �Ѷ��ξ� ������.
	    totalLine=cline.length;//�� ���μ��� �ȴ�.
	    totalPage=(int)Math.ceil(((double)totalLine/(double)pagePerLine));//��ü������ ��
	    content = new String[totalPage];//������ ��ŭ�� �迭 ������ ����

	    for(int i=0;i<totalPage;i++){//+=�� ���� �־��ֹǷ� �ʱ⿡ null���� ���� ���� �������� ���������ʱ�ȭ
	    	content[i]="";
	    }
	    
	    int j=0;//j�� ���������� i�� ���� ����
	    for(int i=0;i<totalLine;i++){//content �迭�� ���������� �� ���� �� ��ŭ ���ڸ� �����Ѵ�.
	    	content[j]+=cline[i]+"<br/>";//html�� ���� ���̹Ƿ� \n��� �Ѷ��� ���� br�±׸� ����
	    	if(((i+1)%pagePerLine)==0){j++;}
	    }

		model.addAttribute("img", service.getImage(mybooknum));
		model.addAttribute("startPage", startPage);
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("content", content);
		
		return "/readbook/readbook";
		
	}
	
	
	//å���� ����� ó���ϴ� �ڵ鷯
	@RequestMapping(value = "/readbook/setmark", method = RequestMethod.POST)
	public void markHandler(@RequestParam("page_number") int page_number, @RequestParam("mybooknum") int mybooknum, Model model){
		
		model.addAttribute("mybooknum", mybooknum);//���� �� �ٽ� å���� ȭ������ ���ư��� ���� ���� �Ѱ���
		service.setBookmark(page_number, mybooknum);//�ϸ�ũ�� ����
	}
	


	
}
