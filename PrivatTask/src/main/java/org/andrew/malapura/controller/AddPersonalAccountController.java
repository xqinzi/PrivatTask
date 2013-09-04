package org.andrew.malapura.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 
 * @author malapura
 *
 *   			Контроллер создание нового ЛИЦЕВОГО СЧЕТА 
 */

public class AddPersonalAccountController extends SimpleFormController {
			
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	private SomeService service = (SomeService) context.getBean("someService");
	
			public AddPersonalAccountController(){
				setCommandClass(PersonalAccount.class);
				setCommandName("PersAcntForm");
			}

			@Override
			protected ModelAndView onSubmit(HttpServletRequest request,
					HttpServletResponse response, Object command,
					BindException errors) throws Exception {
				
				PersonalAccount personalAccount = (PersonalAccount) command;
				System.out.println(personalAccount.getAccountNumber());
				System.out.println(personalAccount.getAccountType());
				return new ModelAndView(new RedirectView("application.htm"));
			}

			@Override
			protected Map<String, Object> referenceData(HttpServletRequest request)
					throws Exception {
				Map<String, Object> referenceData = new HashMap<String, Object>();
				
				// Данные для выпадающего списка квартир
				
				Map<String,Flat> flats = new LinkedHashMap<String,Flat>();
				for (Flat flat : service.getAllFlats()) {
					String address = flat.getHouse().getStreet().getStreetName()+" "+flat.getHouse().getHouseNumber()+"/"+flat.getNumber();
					 flats.put(address , flat);
				}
				referenceData.put("flatList", flats);
				
				// Данные для выпадающего списка владельцев
				
				Map<String,Owner> owners = new LinkedHashMap<String,Owner>();
				for (Owner owner : service.getAllOwners()) {
					 owners.put(owner.getFirstName()+" "+owner.getPatronymic()+" "+owner.getSecondName()+" ("+owner.getInn()+")", owner);
				}
				referenceData.put("ownersList", owners);
				
				
				return referenceData;
			}
			
}
