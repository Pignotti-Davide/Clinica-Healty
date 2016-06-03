package clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Utente;
import clinica.service.impl.FacadeAutenticazione;

@Controller
public class LogController {
	
	@Autowired
	private FacadeAutenticazione facadeAutenticazione;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String toLogIn(@ModelAttribute Utente utente){
		
		return "login";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "index";
	}
	
	@RequestMapping(value="/logUtente", method=RequestMethod.POST)
	public String logUtente(@ModelAttribute Utente utente){
		
		Utente u = facadeAutenticazione.login(utente.getUsername(),utente.getPassword());
		utente.setRole(u.getRole());
		utente=u;
		if(u==null)
			return "error";
		else{
			if(u.getRole().equals("admin"))
				return "protected/homeAdmin";
			else
				if(u.getRole().equals("utente"))
					return "protected/homeUtente";
		}
		
		return "error";
		
		
	}
	
}
