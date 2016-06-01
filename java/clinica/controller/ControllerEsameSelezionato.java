package clinica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Servlet implementation class ControllerEsameSelezionato
 */
@Controller
public class ControllerEsameSelezionato {
	private static final long serialVersionUID = 1L;
       
    
	@RequestMapping(value="", method=RequestMethod.GET)
		public String toEsameSelezionato(){
			return "";
		}
	

	

}
