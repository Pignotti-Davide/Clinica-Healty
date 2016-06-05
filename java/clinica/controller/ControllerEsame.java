package clinica.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
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
    }
	
	@RequestMapping(value="/nuovoEsame", method=RequestMethod.GET)
	public String toNuovoEsame(@ModelAttribute Esame esame,Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			
			model.addAttribute("pazienti", facadePaziente.findAllPazienti());
			model.addAttribute("medici", facadeMedico.findAllMedici());
			model.addAttribute("tipologieEsami", facadeTipologiaEsame.listaTipologiaEsame());

			return "protected/nuovoEsame";
		}
		else return"index";
	}


	@RequestMapping(value="/addEsame", method=RequestMethod.POST)
	public String addEsame(@ModelAttribute Esame esame, Model model){

		String nextPage=null;
		boolean erroriPresenti = false;
		
		if(esame.getMedico()==null){
			erroriPresenti=true;
			model.addAttribute("medicoError", "Campo obbligatorio");
		}
		if(!(isValidDate(esame.getEsecuzioneEsame().toString()))){
			model.addAttribute("dataError", "Data non valida");
		}
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
		else {esame.setPrenotazione(Date.from(Instant.now()));
			facadeEsame.addEsame(esame);
			nextPage="/protected/esameInserito";
		}
		model.addAttribute("esame", esame);
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
}