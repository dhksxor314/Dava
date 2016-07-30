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
import java.util.logging.Logger;

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
	@RequestMapping(value = "/readbook/read", method = RequestMethod.POST)
	public String home(@RequestParam("mybooknum") int mybooknum, HttpServletRequest req, Model model) throws FileNotFoundException, IOException {

		int startPage=service.getBookmark(mybooknum);//책보기를 눌렀을 시 기본 시작페이지는 1이며 책갈피가 등록된 경우에는 책갈피에 등록된 
									
		String path = req.getServletContext().getRealPath("resources/books");

		String title = service.getHwp(mybooknum);

		int pagePerLine=25;//한 페이지당 라인 수
		int charPerLine=40;//
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		
		File hwp = new File(path+"\\"+title); // 텍스트를 추출할 HWP 파일
	    Writer writer = new StringWriter(); // 추출된 텍스트를 출력할 버퍼
	    HwpTextExtractor.extract(hwp, writer); // 파일로부터 텍스트 추출
	    String text = writer.toString(); // 추출된 텍스트
	    String c="";
	    int cnt=0;//한 라인에 현재까지 삽입한 글자 수를 저장
	    for(int i=1;i<=text.length();i++){//charPerLine(한라인의 길이)가 넘는 문단에 \n을 삽입한다. \n을 기준으로 라인을 분리할것이기때문
	    	c+=text.charAt(i-1);
	    	if(text.charAt(i-1)=='\n'){//문단이 나눠진 부분에 \n을 삽입하고 한라인에 넣은 글자수를 0으로 돌린다.
	    		c+='\n';
	    		cnt=0;
	    	}
	    	else{	    		
	    		cnt++;
	    	}
		    if(cnt%charPerLine==0){c+="\n";cnt=0;}//한라인에 40글자가 채워졌을 때 \n을 삽입하고 cnt를 0으로 초기화	
	    }
	    
	    String cline[] = c.split("\n");//위에서 \n을 삽입한 것을 이용하여 한라인씩 나눈다.
	    totalLine=cline.length;//총 라인수가 된다.
	    totalPage=(int)Math.ceil(((double)totalLine/(double)pagePerLine));//전체페이지 수
	    content = new String[totalPage];

	    for(int i=0;i<totalPage;i++){
	    	content[i]="";
	    }
	    
	    int j=0;
	    for(int i=0;i<totalLine;i++){//content 배열에 한페이지당 들어갈 라인 수 만큼 글자를 삽입한다.
	    	content[j]+=cline[i]+"<br/>";
	    	if(((i+1)%pagePerLine)==0){j++;}
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
