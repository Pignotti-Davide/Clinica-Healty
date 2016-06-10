package clinica.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.util.TimeZone;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
	@Autowired
	@Qualifier("esameValidator")
	private Validator validator;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
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
	public String addEsame(@RequestParam("esecuzioneEsame")Date data, @ModelAttribute Esame esame, Model model){
		if(data==null){
			model.addAttribute("dataError","Campo Obbligatorio");
			return "protected/nuovoEsame";
		}
		esame.setPrenotazione(Date.from(Instant.now()));
		
		Map<String,String> risultati=new HashMap<String, String>();
		for(String s:esame.getTipologia().getIndicatoriRisultati())
			risultati.put(s, "");
		esame.setRisultati(risultati);
		facadeEsame.addEsame(esame);
		return "protected/esameInserito";
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
	@RequestMapping(value="/eliminaEsame", method=RequestMethod.POST)
	public String deleteTipologiaEsame(@ModelAttribute Esame esame,Model model){
		long id = esame.getIdEsame();
		facadeEsame.deleteEsame(id);
		model.addAttribute("elemento","Esame");
		return "protected/eliminazione";
	}

	@RequestMapping(value="/inserisciRisultati", method=RequestMethod.GET)
	public String toInserisciRisultati(Model model){
		model.addAttribute("esame",new Esame());
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

	@RequestMapping(value="/addRisultati", method=RequestMethod.POST)
	public String addRisultati(@ModelAttribute Esame esame,HttpServletRequest request,Model model){
		long id= esame.getIdEsame();
		Esame e = facadeEsame.findEsame(id);
		System.out.print(e);
		List<String> nomiRisultati = e.getTipologia().getIndicatoriRisultati();
		for(String s:nomiRisultati){
			e.getRisultati().put(s, request.getParameter("risultato"+s));
		}
		for(String risultato: e.getRisultati().keySet()){
			if(e.getRisultati().get(risultato)==null){
				model.addAttribute("risultatoError","Inserisci risultato");
				model.addAttribute("esami", facadeEsame.findAll());
				model.addAttribute("esame", e);
				return"/protected/inserimentoRisultati";
			}
				
		}
		facadeEsame.updateEsame(e);
		model.addAttribute("risultati",e.getRisultati());
		System.out.println(e.getRisultati());
		model.addAttribute("id", e.getIdEsame());

		return "/protected/risultatiInseriti";
	}
	public Map<String,String> creaMappaRisultati(Esame e,HttpServletRequest request){
		Map<String,String> mappaRisultati = new HashMap<>();
		List<String> nomi= e.getTipologia().getIndicatoriRisultati();
		for(String s:nomi){
			if(request.getAttribute("risultato"+s)!=null){
				mappaRisultati.put(s, (String)request.getAttribute("risultato"+s));
			}
		}
		return mappaRisultati;
	}
}
