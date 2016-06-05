package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeMedico;

@Controller
public class ControllerMedico {

	@Autowired
	private FacadeMedico facadeMedico;
	
	@RequestMapping(value="/nuovoMedico",method=RequestMethod.GET)
	public String toNuovoMedico(@ModelAttribute Medico medico){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovoMedico";
		}
		else return"index";}

	@RequestMapping(value="/addMedico", method=RequestMethod.POST)
	public String addMedico(@ModelAttribute Medico medico,Model model){
		boolean erroriPresenti = false;
		String nextPage=null;

		if(medico.getNome().isEmpty()){
			erroriPresenti=true;
			model.addAttribute("nomeError", "Campo obbligatorio");
		}
		if(medico.getSpecializzazione().equals("")){
			erroriPresenti=true;
			model.addAttribute("cognomeError", "Campo obbligatorio");
		}
		if(medico.getCognome().equals("")){
			erroriPresenti=true;
			model.addAttribute("specializzazioneError", "Campo obbligatorio");
		}
		if(erroriPresenti){
			nextPage  = "protected/nuovoMedico";
		}
		else {nextPage="protected/medicoinserito";
		facadeMedico.addMedico(medico);
		}
		return nextPage;
	}
	@RequestMapping(value="/listaMedici", method=RequestMethod.GET)
	public String toListaMedici(Model model){
		List<Medico>lista=(ArrayList<Medico>)facadeMedico.findAll();
		
		model.addAttribute("lista", lista);
		return "listaMedici";

	}
	@RequestMapping(value="/eliminaMedico/{id}",method = RequestMethod.GET)
	public String deleteMedico(@PathVariable("id")long Id,@ModelAttribute Medico medico){
		facadeMedico.deleteMedico(Id);
		return "homeAdmin";
	}
}