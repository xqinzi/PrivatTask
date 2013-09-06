package org.andrew.malapura.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class FindController extends SimpleFormController {
	
	ArrayList<String> findParameters = new ArrayList<String>();
	
	public FindController(){
		setCommandClass(RequiredValue.class);
		setCommandName("findForm");
		Init();
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors)
		throws Exception {
 
		RequiredValue requiredValue = (RequiredValue)command;
		return new ModelAndView("TaskView","requiredValue",requiredValue);
 
	}
	
	private void Init(){
		findParameters.add("номер дома");
		findParameters.add("номер квартиры");
		findParameters.add("номер лиц. счета");
		findParameters.add("адрес");
		findParameters.add("название улицы");
	}
	
	@Override
	protected Map<String, ArrayList<String>> referenceData(HttpServletRequest request) throws Exception {
		 
		Map<String, ArrayList<String>> referenceData = new HashMap<String, ArrayList<String>>();

		referenceData.put("findParameters", findParameters);
		
		return referenceData;
	}	
	public final ArrayList<String> getFindParameters() {
		return findParameters;
	}
	
	// *************** Inner class ***************
	
	public class RequiredValue {
		private String parameter;
		private String value;
		
		public final String getParameter() {
			return parameter;
		}
		public final void setParameter(String parameter) {
			this.parameter = parameter;
		}
		public final String getValue() {
			return value;
		}
		public final void setValue(String value) {
			this.value = value;
		}
	}

}
