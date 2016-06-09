package clinica.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import clinica.model.TipologiaEsame;

public class ValidatorTipologiaEsame implements Validator{
	public boolean supports(Class<?> clazz) {
		return TipologiaEsame.class.equals(clazz);
	}


	@Override
	public void validate(Object target, Errors e) {
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "nome", "nome.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "descrizione", "descrizione.required");
	}
}


