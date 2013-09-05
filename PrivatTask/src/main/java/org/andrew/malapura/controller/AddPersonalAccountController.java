package org.andrew.malapura.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.andrew.malapura.entity.Flat;
import org.andrew.malapura.entity.Owner;
import org.andrew.malapura.entity.PersonalAccount;
import org.andrew.malapura.service.SomeService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
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
		   /**
		    * 		задаём тип объекта (класс) который будет приходить из формы
		    */
			public AddPersonalAccountController(){
				setCommandClass(SimplePersonalAccount.class);
				setCommandName("addPersonalAccountForm");
			}
			 /**
			  *   метод вызываемый по событию
			  */
			@Override
			protected ModelAndView onSubmit(HttpServletRequest request,
					HttpServletResponse response, Object command,
					BindException errors) throws Exception {
				System.out.println("onSubmit");
			SimplePersonalAccount simplePersonalAccount = (SimplePersonalAccount) command;			
		    service.addPersonalAccount(simplePersonalAccount.convert());
				return new ModelAndView(new RedirectView("application.htm"));
			}
			/**
			 * 	метод для создания dropBox-ов
			 */
			@Override
			protected Map<String, Map<?, String>> referenceData(HttpServletRequest request)
					throws Exception {
				
				Map<String, Map<?, String>> referenceData = new HashMap<String, Map<?, String>>();
				
				// Данные для выпадающего списка квартир
				
				Map<String, String> simpleFlats = new LinkedHashMap<String, String>();
				for (Flat flat : service.getAllFlats()) {
					String flatDropBoxItem = flat.getHouse().getStreet().getStreetName()+" "+flat.getHouse().getHouseNumber()+"/"+flat.getNumber();
					String flatId = flat.getId().toString();
					simpleFlats.put(flatId,  flatDropBoxItem);
				}
				referenceData.put("flatList", simpleFlats);
				
				// Данные для выпадающего списка владельцев
				
				Map<String, String> simpleOwners = new LinkedHashMap<String, String>();
				for (Owner owner : service.getAllOwners()) {
					String ownerDropBoxItem = owner.getFirstName()+" "+owner.getPatronymic()+" "+owner.getSecondName()+" ("+owner.getInn()+")";
					String ownerId = owner.getId().toString();
					 simpleOwners.put( ownerId, ownerDropBoxItem);
				}
				referenceData.put("ownerList", simpleOwners);
				
				
				return referenceData;
			}
			
			@Override
			 protected Object formBackingObject(HttpServletRequest request) {
			        SimplePersonalAccount spa = new SimplePersonalAccount();			        
			        return spa;
			    }

			/**
			 *  для типа ДАТА
			 */
			@Override
			protected void initBinder(HttpServletRequest request,
					ServletRequestDataBinder binder) throws Exception {
				
				DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			    df.setLenient(false);
			    binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
			    
				super.initBinder(request, binder);
			}
			 /**
			  *  Упрощенный класс Л.С. для получения данных из формы
			  * @author mav
			  *
			  */
			public class SimplePersonalAccount{
				private String accountNumber;   // номер лицевого счета
				private String accountType;		 // тип л.с. (квартплата, водоснабжение, газоснабжение)
				private String strFlatID;				     // квартира 
				private String strOwnerID;				 // владелец лицевого счета
				private Date createdDate;          // дата создания л.с.
				
				protected PersonalAccount convert(){
					PersonalAccount pa = new PersonalAccount();
					try{			
						pa.setAccountNumber(accountNumber);
						pa.setAccountType(accountType);
						pa.setCreatedDate(createdDate);
						pa.setFlat(service.findFlatById(new Long(strFlatID)));
						pa.setOwner(service.findOwnerById(new Long(strOwnerID)));
					}catch(Exception e){
						return null;	
					}
						return pa;
				}
				
				/**
				 * @return the accountNumber
				 */
				public final String getAccountNumber() {
					return accountNumber;
				}
				/**
				 * @param accountNumber the accountNumber to set
				 */
				public final void setAccountNumber(String accountNumber) {
					this.accountNumber = accountNumber;
				}
				/**
				 * @return the accountType
				 */
				public final String getAccountType() {
					return accountType;
				}
				/**
				 * @param accountType the accountType to set
				 */
				public final void setAccountType(String accountType) {
					this.accountType = accountType;
				}
				
				/**
				 * @return the createdDate
				 */
				public final Date getCreatedDate() {
					return createdDate;
				}
				/**
				 * @param createdDate the createdDate to set
				 */
				public final void setCreatedDate(Date createdDate) {
					this.createdDate = createdDate;
				}
				/**
				 * @return the strFlatID
				 */
				public final String getStrFlatID() {
					return strFlatID;
				}
				/**
				 * @param strFlatID the strFlatID to set
				 */
				public final void setStrFlatID(String strFlatID) {
					this.strFlatID = strFlatID;
				}
				/**
				 * @return the strOwnerID
				 */
				public final String getStrOwnerID() {
					return strOwnerID;
				}
				/**
				 * @param strOwnerID the strOwnerID to set
				 */
				public final void setStrOwnerID(String strOwnerID) {
					this.strOwnerID = strOwnerID;
				}
			}
}
