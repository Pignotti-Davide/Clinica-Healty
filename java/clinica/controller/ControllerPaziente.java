package clinica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.Paziente;

import clinica.service.impl.FacadePaziente;
@Controller
public class ControllerPaziente {
	@Autowired
	private FacadePaziente facadePaziente;
	@Autowired
	@Qualifier("pazienteValidator")
	private Validator validator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
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
	
	@RequestMapping(value="/mostraRisultatiPaziente", method=RequestMethod.POST)
	public String RisultatiPaziente(@ModelAttribute Paziente paziente,
			HttpServletRequest request, Model model){
		if(request.getParameter("code").equals("")){
			model.addAttribute("idError", "Inserire il codice");
		
			return "risultatiPaziente";
		}
		else{
			  long id=Long.parseLong(request.getParameter("code"));
			 paziente = facadePaziente.retrievePaziente(id);
			 if(paziente==null)
				 model.addAttribute("pazienteError","Nessun paziente associato a questo codice");
			 else{
			model.addAttribute("idError","");
			model.addAttribute("pazienteNome",paziente.getNome());
			
			 List<Esame> listaEsamiPaziente=facadePaziente.listaEsami(id);
			 model.addAttribute("paziente",paziente);
			 model.addAttribute("listaEsamiPaziente",listaEsamiPaziente);
			 }
		}
		return "risultatiPaziente";
		  }
	

	@RequestMapping(value="/addPaziente", method=RequestMethod.POST)
	public String addPaziente(@ModelAttribute Paziente paziente,Model model,@Validated Paziente p,BindingResult bindingResult){
		if (bindingResult.hasErrors()) 
			return "protected/nuovoPaziente";
		facadePaziente.addPaziente(paziente);
		return "protected/pazienteInserito";   
	}
	@RequestMapping(value="/eliminaPaziente/{id}",method = RequestMethod.GET)
	public String deleteTipologiaEsame(@PathVariable("id")long Id,@ModelAttribute Paziente paziente,
			Model model){
		facadePaziente.deletePaziente(Id);

		model.addAttribute("elemento","Paziente");
		return "protected/eliminazione";
	}
}
