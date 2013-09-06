package org.andrew.malapura.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.House;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.Street;
import org.andrew.malapura.service.SomeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.RedirectView;
/**
 * 		 онтроллер страницы справочники
 * 
 * @author malapura
 *
 */
public class ReferenceBookController implements Controller {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-module.xml");
	private SomeService service = (SomeService) context.getBean("someService");
	/**
	 *    коллекции объектов сущностей
	 */
	private ArrayList<Owner> ownerList = null;
	private ArrayList<Flat> flatList = null;
	private ArrayList<House> houseList = null;
	private ArrayList<Street> streetList = null;

	public ModelAndView handleRequest(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		
		ModelAndView mv = null;
		
			try{
				/**
				 *    просматриваем параметры GET запроса
				 *    если параметров нет получаем исключение  NullPointerException
				 */
			if(request.getParameter("type").equals("street")){ //  если улица
				 service.deleteStreet(service.findStreetById(new Long(request.getParameter("id")))); // удаление улица
				 mv = new ModelAndView(new RedirectView("referencebook.htm"));
				 	return mv;
			}else if(request.getParameter("type").equals("house")){ //  если дом
				service.deleteHouse(service.findHouseById(new Long(request.getParameter("id")))); //  удаление дом
				 mv = new ModelAndView(new RedirectView("referencebook.htm"));
			}else if(request.getParameter("type").equals("flat")){  //  если квартира
				service.deleteFlat(service.findFlatById(new Long(request.getParameter("id"))));  // удаление квартира
				 mv = new ModelAndView(new RedirectView("referencebook.htm"));
			}else if(request.getParameter("type").equals("owner")){ //  если владелец
				service.deleteOwner(service.findOwnerById(new Long(request.getParameter("id")))); // удаление владелец
				 mv = new ModelAndView(new RedirectView("referencebook.htm"));
			}	
			}catch(NullPointerException e){ // обработка исключени€
				mv = new ModelAndView("referencebook");
			ownerList = (ArrayList<Owner>) service.getAllOwners();
			mv.addObject("owners", ownerList);
			flatList = (ArrayList<Flat>) service.getAllFlats();
			mv.addObject("flats", flatList);
			houseList = (ArrayList<House>) service.getAllHouses();
			mv.addObject("houses", houseList);
			streetList = (ArrayList<Street>) service.getAllStreet();
			mv.addObject("streets", streetList);
			}
		return mv;
	}

	//************ getters and setters ***************
	
	public final ArrayList<Owner> getOwnerList() {
		return ownerList;
	}

	public final void setOwnerList(ArrayList<Owner> ownerList) {
		this.ownerList = ownerList;
	}

	public final ArrayList<Flat> getFlatList() {
		return flatList;
	}

	public final void setFlatList(ArrayList<Flat> flatList) {
		this.flatList = flatList;
	}

	public final ArrayList<House> getHouseList() {
		return houseList;
	}

	public final void setHouseList(ArrayList<House> houseList) {
		this.houseList = houseList;
	}

	public final ArrayList<Street> getStreetList() {
		return streetList;
	}

	public final void setStreetList(ArrayList<Street> streetList) {
		this.streetList = streetList;
	}

}
