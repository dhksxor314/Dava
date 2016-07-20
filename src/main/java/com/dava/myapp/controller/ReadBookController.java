/*
 * 설명 : 책 읽는 페이지로 이동하면서 해당 책에 맞는 책 정보를 불러온다.
 * 
 */

package com.dava.myapp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReadBookController {

	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(Model model) {
		String title="moon";
		int totalPage = 4;
		String path="";
		String[] content=null;
		BufferedReader[] br=null;
		
		try {
			for(int i=0;i<totalPage;i++){
				path = "J:\\final\\Dava\\src\\main\\webapp\\resources\\books\\"+title+"\\"+(i+1)+".txt";
				br[i] = new BufferedReader(new FileReader(new File(path)));
				String a="";
				while((a=br[i].readLine())!=null){
					content[i]+=a+"\n";
				}
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재 하지 않습니다.");
		} catch (IOException e) {
			System.out.println("입출력 에러");
		} finally{
			for(int i=0;i<totalPage;i++){
				try {br[i].close();} catch (IOException e) {System.out.println("BuffredReader 닫기 중 에러");}
			}
		}
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("content", content);
		
		
		return "/readbook/readbook";
	}


	
}
