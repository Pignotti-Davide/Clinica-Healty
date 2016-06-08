package clinica.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import clinica.model.Paziente;



public class ValidatorPaziente implements Validator{
	public boolean supports(Class<?> clazz) {
		return Paziente.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors e) {
		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "nome", "nome.required");
		   ValidationUtils.rejectIfEmptyOrWhitespace(e, "cognome", "cognome.required");
		
//		   System.out.println(e.getFieldError("idPaziente"));
	      
	}

}
