package org.andrew.malapura.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
/**
 * 	 онтроллер главной страницы приложени€
 * @author malapura
 *
 */
public class TaskViewController implements Controller{

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	private SomeService service = (SomeService) context.getBean("someService");
	private ArrayList<PersonalAccount> tableData ;
	
	public ModelAndView handleRequest(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		try{
				tableData = (ArrayList<PersonalAccount>)service.getAllPersonalAccounts();
		}catch(Exception e){
		e.printStackTrace();
		}		
		ModelAndView mv = new ModelAndView("application");
		mv.addObject("tableData",tableData);
		return mv;
	}

	// *************  Getter and Setters ***********************
	
	public final ArrayList<PersonalAccount> getTableData() {
		return tableData;
	}

	public final void setTableData(ArrayList<PersonalAccount> tableData) {
		this.tableData = tableData;
	}

}
