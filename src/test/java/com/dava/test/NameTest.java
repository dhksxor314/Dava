package com.dava.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class NameTest {
	
	private static final Logger logger = LoggerFactory.getLogger(NameTest.class);

	String name = "abcd.hwp";
	
	@Test
	public void test() throws Exception{
		String newname = name.replace(".hwp", ".txt");
		logger.info(newname);
	}
	
	
}
