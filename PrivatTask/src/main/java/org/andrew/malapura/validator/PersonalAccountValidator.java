package org.andrew.malapura.validator;

import org.andrew.malapura.controller.AddPersonalAccountController;
import org.andrew.malapura.controller.AddPersonalAccountController.SimplePersonalAccount;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
/**
 *  класс валидатор для формы добавления Л.С.
 * @author mav
 *
 */
public class PersonalAccountValidator implements Validator {

	public boolean supports(Class clazz) {
		return SimplePersonalAccount.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
			
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"accountNumber","required.accountNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"accountType","required.accountType");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"createdDate","required.createdDate");
		
		SimplePersonalAccount formData = (SimplePersonalAccount) target;
		if("NONE".equals(formData.getStrFlatID())){
			errors.rejectValue("strFlatID", "required.address");
		}
		if("NONE".equals(formData.getStrOwnerID())){
			errors.rejectValue("strOwnerID", "required.owner");
		}
	}

}
