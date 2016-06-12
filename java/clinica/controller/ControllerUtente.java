package clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import clinica.model.Paziente;
import clinica.model.Utente;
import clinica.service.impl.FacadeUtente;
@Controller
public class ControllerUtente extends WebMvcConfigurerAdapter{
	@Autowired
	private FacadeUtente facadeUtente;
	@Autowired
	@Qualifier("utenteValidator")
	private Validator validator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value="/registrazione", method=RequestMethod.GET)
	public String toRegistrazione(@ModelAttribute Utente utente){
		
		return"registrazione";
	}
	@RequestMapping(value="/addUtente", method=RequestMethod.POST)
	public String addUtente(@ModelAttribute Utente utente,Model model,@Validated Utente p,BindingResult bindingResult){
		Utente u = facadeUtente.retrieveUtente(utente.getUsername());
		if (bindingResult.hasErrors()) {
			return "registrazione";
		}
		if(u !=null){
			model.addAttribute("usernameError","Username già esistente");
			return "registrazione";
		}
		System.out.println(u);
		facadeUtente.addUtente(utente);
		return "utente/risultatiPaziente";   
	}
	
}
