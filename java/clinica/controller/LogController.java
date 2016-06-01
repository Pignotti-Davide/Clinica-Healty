package clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Utente;
import clinica.service.impl.FacadeAutenticazione;

@Controller
public class LogController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String toLogIn(@ModelAttribute Utente utente, Model model){
		model.addAttribute("utente",utente);
		return "login";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "index";
	}
	
	@RequestMapping(value="/logUtente", method=RequestMethod.POST)
	public String logUtente(@ModelAttribute Utente utente){
		FacadeAutenticazione autenticazione = new FacadeAutenticazione();
		autenticazione.setEm(null);
		
		Utente u = autenticazione.login(utente.getUsername(),utente.getPassword());
		if(u==null)
			return "error";
		else{
			if(u.getRole().equals("admin"))
				return "/protected/homeAdmin";
			else
				if(u.getRole().equals("utente"))
					return "protected/homeUtente";
		}
		return "error";
		
		
	}
	
}
