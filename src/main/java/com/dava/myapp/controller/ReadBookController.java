/*
 * 설명 : 책 읽는 페이지로 이동하면서 해당 책에 맞는 책 정보를 불러온다.
 * 작성자 : 전현영
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
		
		String title = "달빛조각사1";
		int pageCutline=30;//한 페이지당 라인 수
		int totalPage = 0;
		int totalLine=1;
		String[] content=null;
		BufferedReader br=null;
		
		
		try {
			br=new BufferedReader(new FileReader(new File(path+"\\books\\"+title+".txt")));
			String a="";
			
			while(br.readLine()!=null){//책 한권의 총 라인 수를 먼저 구한다.  
				totalLine++;
			}
			
			totalPage=(int)Math.ceil(((double)totalLine/(double)pageCutline));//올림 함수를 써서 총 페이지를 구함
			
			
			content=new String[totalPage];//content배열을 페이지 수 만큼 초기화하기 위해서
			for(int i=0;i<totalPage;i++){//이 작업이 없을 시 첫글자에 null이 들어감
				content[i]="";
			}
			
			br=new BufferedReader(new FileReader(new File(path+"\\books\\"+title+".txt")));//다시 책을 불러온다.
			int cnt=0;//페이지 번호
			int line=1;//pageCutline을 맞추기 위해서 사용

			while((a=br.readLine())!=null){//30라인을 1페이지로 잡고 데이터를 넣어준다.
				content[cnt]+=a+"<br/>";
				if(line==pageCutline){line=1;cnt++;}
				else{line++;}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
		} catch (IOException e) {
			System.out.println("입출력 에러");
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
