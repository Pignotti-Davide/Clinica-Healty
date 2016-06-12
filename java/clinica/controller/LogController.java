package clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Utente;

@Controller
public class LogController {
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "index";
	}
	
	@RequestMapping(value="/admin**", method=RequestMethod.GET)
	public String logAdmin(){
		return "protected/homeAdmin";
	}
	@RequestMapping(value="/utente**", method=RequestMethod.GET)
	public String logUtente(){
		return "utente/risultatiPaziente";
	}
	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String login(ModelMap model) {
		  model.addAttribute("user", new Utente());
	        return "login";
	    }
	
}
