package clinica.controller.Nuovo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Paziente;
import clinica.service.impl.FacadePaziente;

/**
 * Servlet implementation class ControllerNuovoPaziente
 */
@Controller
public class ControllerPaziente {
	@Autowired
	private FacadePaziente facadePaziente;
	
   @RequestMapping(value="/nuovoPaziente", method=RequestMethod.GET)
   public String toNuovoPaziente(@ModelAttribute Paziente paziente){
	   return "protected/nuovoPaziente";
   }
   @RequestMapping(value="/pazienteInserito")
   public String toPazienteInserito(@ModelAttribute Paziente paziente){
	   return "protected/pazienteInserito";
   }

   @RequestMapping(value="/addPaziente", method=RequestMethod.POST)
   public String addPaziente(@ModelAttribute Paziente paziente,Model model){
	   boolean erroriPresenti = false;
		String nextPage=null;

		if(paziente.getNome().equals("")){
			erroriPresenti=true;
			model.addAttribute("nomeError", "Campo obbligatorio");
		}
		if(paziente.getCognome().equals("")){
			erroriPresenti=true;
			model.addAttribute("cognomeError", "Campo obbligatorio");
		}
		if(erroriPresenti)
			nextPage  = "nuovoPaziente";
		else {nextPage="pazienteInserito";
		facadePaziente.addPazziente(paziente);
		}
	return nextPage;   
   }
}
