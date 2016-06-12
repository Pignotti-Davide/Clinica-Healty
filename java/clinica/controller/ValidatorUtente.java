package clinica.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import clinica.model.Utente;

public class ValidatorUtente implements Validator{
	public boolean supports(Class<?> clazz) {
		return Utente.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors e) {
		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "username", "NotNull");
		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "password", "NotNull");
	      
	}
}
