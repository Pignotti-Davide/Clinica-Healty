package clinica.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.TimeZone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import clinica.model.Esame;
import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.TipologiaEsame;
import clinica.service.editors.EditorMedico;
import clinica.service.editors.EditorPaziente;
import clinica.service.editors.EditorTipologiaEsame;
import clinica.service.impl.FacadeEsame;
import clinica.service.impl.FacadeMedico;
import clinica.service.impl.FacadePaziente;
import clinica.service.impl.FacadeTipologiaEsame;
@Controller
public class ControllerEsame {
	private @Autowired EditorPaziente editorPaziente;
	private @Autowired EditorMedico editorMedico ;
	private @Autowired EditorTipologiaEsame editorTipologiaEsame;
	@Autowired
	private FacadeEsame facadeEsame;
	@Autowired
	private FacadePaziente facadePaziente;
	@Autowired
	private FacadeMedico facadeMedico;
	@Autowired
	private FacadeTipologiaEsame facadeTipologiaEsame;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Paziente.class, this.editorPaziente);
		binder.registerCustomEditor(TipologiaEsame.class, this.editorTipologiaEsame);
		binder.registerCustomEditor(Medico.class, this.editorMedico);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setTimeZone(TimeZone.getDefault());
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value="/nuovoEsame", method=RequestMethod.GET)
	public String toNuovoEsame(@ModelAttribute Esame esame,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {

			model.addAttribute("pazienti", facadePaziente.findAll());
			model.addAttribute("medici", facadeMedico.findAll());
			model.addAttribute("tipologieEsami", facadeTipologiaEsame.findAll());

			return "protected/nuovoEsame";
		}
		else return"index";
	}


	@RequestMapping(value="/addEsame", method=RequestMethod.POST)



	public String addEsame(@RequestParam("field2")Date data, @ModelAttribute Esame esame, Model model){


		String nextPage=null;
		boolean erroriPresenti = false;

		if(esame.getMedico()==null){
			erroriPresenti=true;
			model.addAttribute("medicoError", "Campo obbligatorio");
		}
		//		if(!(isValidDate(esame.getEsecuzioneEsame().toString()))){
		//			model.addAttribute("dataError", "Data non valida");
		//		}
		if(esame.getPaziente()==null){
			erroriPresenti=true;
			model.addAttribute("pazienteError", "Campo obbligatorio");
		}
		if(esame.getTipologia()==null){
			erroriPresenti=true;
			model.addAttribute("tipologiaEsameError", "Campo obbligatorio");
		}

		if(erroriPresenti)
			nextPage  = "/nuovoEsame";

		else {
			esame.setPrenotazione(Date.from(Instant.now()));
		
		Map<String,String> risultati=new HashMap<String, String>();
		for(String s:esame.getTipologia().getIndicatoriRisultati())
			risultati.put(s, "");
		esame.setRisultati(risultati);
		facadeEsame.addEsame(esame);
		nextPage="/protected/esameInserito";
		}
		
		return nextPage;
		}
	


		public  boolean isValidDate(String inDate) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(inDate.trim());
			} catch (ParseException pe) {
				return false;
			}
			return true;
		}
		@RequestMapping(value="/eliminaEsame/{id}",method = RequestMethod.GET)
		public String deleteEsame(@PathVariable("id")long Id,@ModelAttribute Esame Esame){
			facadeEsame.deleteEsame(Id);
			return "index";
		}

		@RequestMapping(value="/inserisciRisultati", method=RequestMethod.GET)
		public String toInserisciRisultati(Model model){
			model.addAttribute("esami", facadeEsame.findAll());
			return "/protected/inserimentoRisultati";
		}

		@RequestMapping(value="/mostraEsame", method=RequestMethod.POST)
		public String mostraEsame(HttpServletRequest request, Model model){
			long id=Long.parseLong(request.getParameter("esame"));
			Esame esame=facadeEsame.findEsame(id);
			model.addAttribute("esame", esame);
			model.addAttribute("esami", facadeEsame.findAll());
			return "/protected/inserimentoRisultati";

		}
	}
