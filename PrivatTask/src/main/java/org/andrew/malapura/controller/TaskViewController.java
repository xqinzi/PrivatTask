package org.andrew.malapura.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrew.malapura.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class TaskViewController implements Controller{

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	private SomeService service = (SomeService) context.getBean("someService");
	
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		try{
				System.out.println(service.findByOwnerName("Николай", "Петрович", "Бородач").size()) ;
		}catch(Exception e){
		e.printStackTrace();
		}

		
		
		ModelAndView mv = new ModelAndView("application");
		return mv;
	}

}
