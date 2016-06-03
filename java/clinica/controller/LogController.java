package clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogController {
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "index";
	}
	
	@RequestMapping(value="/admin**", method=RequestMethod.GET)
	public String logUtente(){
		return "protected/homeAdmin";
	}
	
}
