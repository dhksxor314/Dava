/*
 * 설명 : 책 읽는 페이지로 이동하면서 해당 책에 맞는 책 정보를 불러온다.
 * 작성자 : 전현영
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
	
	
	//구매한 책에서 보기를 선택했을 시에 책을 보여주기 위한 로직을 가진 핸들러
	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(@RequestParam("mybooknum") int mybooknum, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {
		
		int startPage=1;
		
		if(service.getBookmark(mybooknum)!=1){
			startPage=service.getBookmark(mybooknum);
		}

		String path = req.getServletContext().getRealPath("resources");

		String title = service.getTitle(mybooknum);
		int pageCutline=25;//한 페이지당 라인 수
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		
		File hwp = new File(path+"\\books\\"+title+".hwp"); // 텍스트를 추출할 HWP 파일
	    Writer writer = new StringWriter(); // 추출된 텍스트를 출력할 버퍼
	    HwpTextExtractor.extract(hwp, writer); // 파일로부터 텍스트 추출
	    String text = writer.toString(); // 추출된 텍스트
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
	
	
	//책갈피 등록을 처리하는 핸들러
	@RequestMapping(value = "/readbook/setmark", method = RequestMethod.POST)
	public String markHandler(@RequestParam("page_number") int page_number, @RequestParam("mybooknum") int mybooknum, Model model){
		
		model.addAttribute("mybooknum", mybooknum);
		service.setBookmark(page_number, mybooknum);
		return "redirect:/readbook/read";
	}
	


	
}
