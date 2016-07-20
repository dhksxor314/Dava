/*
 * ���� : å �д� �������� �̵��ϸ鼭 �ش� å�� �´� å ������ �ҷ��´�.
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ReadBookController {

	@RequestMapping(value = "/readbook/read", method = RequestMethod.GET)
	public String home(Model model) {
		
		String title="moon";
		int totalPage = 4;
		String path="";
		String[] content = new String[totalPage];
		BufferedReader[] br = new BufferedReader[totalPage];
		
		try {
			for(int i=0;i<totalPage;i++){
				content[i]="";
				path = "J:\\final\\Dava\\src\\main\\webapp\\resources\\books\\"+title+"\\"+(i+1)+".txt";

				br[i] = new BufferedReader(new FileReader(new File(path)));
				String a="";
				while((a=br[i].readLine())!=null){
					content[i]+=a+"<br/>";
				}

			}
			
		} catch(FileNotFoundException e){
			System.out.println("������ �����ϴ�");
		} catch (IOException e) {
			System.out.println("����� ����");
		} finally {
			for(int i=0;i<totalPage;i++){
				try {br[i].close();} catch (IOException e) {e.printStackTrace();}
			}
		}
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("content", content);
		
		return "/readbook/readbook";
	}


	
}
