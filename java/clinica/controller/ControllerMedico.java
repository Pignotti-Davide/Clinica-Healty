package clinica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeMedico;


@Controller
public class ControllerMedico {

	@Autowired
	private FacadeMedico facadeMedico;
	@Autowired
	@Qualifier("medicoValidator")
	private Validator validator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value="/nuovoMedico",method=RequestMethod.GET)
	public String toNuovoMedico(@ModelAttribute Medico medico){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovoMedico";
		}
		else return"index";}
	@RequestMapping(value="/addMedico", method=RequestMethod.POST)
	public String addMedico(@ModelAttribute Medico medico,Model model,
			@Validated Medico m,BindingResult bindingResult){
		boolean erroriPresenti = false;
		String nextPage=null;
		if (bindingResult.hasErrors()) 
			return "protected/nuovoMedico";

		facadeMedico.addMedico(medico);
		
		return "protected/medicoinserito";
	}
	@RequestMapping(value="/listaMedici", method=RequestMethod.GET)
	public String toListaMedici(Model model){
		List<Medico>lista=(ArrayList<Medico>)facadeMedico.findAll();
		
		model.addAttribute("lista", lista);
		return "listaMedici";

	}
	@RequestMapping(value="/ricercaMedico",method=RequestMethod.GET)
	public String toRicercaMedico(@ModelAttribute Medico medico){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/ricercaMedico";
		}
		else
			return"index";
		}
	@RequestMapping(value="/ricercaEsamiMedico", method=RequestMethod.POST)
	public String toEsamiMedico(@Validated Medico m,BindingResult bindingResult,@RequestParam("nome") String nome,
			@RequestParam("cognome") String cognome,Model model){
		if (bindingResult.hasErrors()) 
			return "protected/ricercaMedico";
		Medico medico = facadeMedico.retrieveMedicoNomeCognome(nome, cognome);
		List<Esame>lista=(ArrayList<Esame>)facadeMedico.listaEsami(medico.getIdMedico());
		model.addAttribute("lista", lista);
		model.addAttribute("medico",medico);
		return "protected/ricercaEsamiMedico";

	}
	@RequestMapping(value="/eliminaMedico", method=RequestMethod.POST)
	public String deleteTipologiaEsame(@ModelAttribute Medico medico,Model model){
		long id = medico.getIdMedico();
		facadeMedico.deleteMedico(id);
		model.addAttribute("elemento","Medico");
		return "protected/eliminazione";
	}



}