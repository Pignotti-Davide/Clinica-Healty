package clinica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Esame;
import clinica.model.Paziente;
import clinica.service.impl.FacadePaziente;
@Controller
public class ControllerPaziente {
	@Autowired
	private FacadePaziente facadePaziente;

	@RequestMapping(value="/nuovoPaziente", method=RequestMethod.GET)
	public String toNuovoPaziente(@ModelAttribute Paziente paziente){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovoPaziente";
		}
		else return"index";
	}
	@RequestMapping(value="/risultatiPaziente", method=RequestMethod.GET)
	public String toPaginaPaziente(){
		return "risultatiPaziente";
	}
	
	@RequestMapping(value="/mostraRisultatiPaziente", method=RequestMethod.GET)
	public String RisultatiPaziente(@Validated Paziente paziente, BindingResult result,
			HttpServletRequest request, Model model){
		  if(result.hasErrors()){
	            return "risultatiPaziente";
	        }
		  else{
			  long id=Long.parseLong(request.getParameter("code"));
			 paziente = facadePaziente.retrievePaziente(id);
			 List<Esame> listaEsamiPaziente=facadePaziente.listaEsami(id);
			 model.addAttribute("paziente",paziente);
			 model.addAttribute("listaEsamiPaziente",listaEsamiPaziente);
			 
		return "risultatiPaziente";
		  }
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
			nextPage  = "protected/nuovoPaziente";
		else {
			nextPage="protected/pazienteInserito";
		}
		facadePaziente.addPaziente(paziente);
		return nextPage;   
	}
}
