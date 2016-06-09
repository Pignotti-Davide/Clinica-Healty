package clinica.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import clinica.model.Esame;
public class ValidatorEsame implements Validator{
	public boolean supports(Class<?> clazz) {
		return Esame.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors e) {
		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "risultati", "id.required");
		   System.out.println(e.getAllErrors());
	}
	
}
