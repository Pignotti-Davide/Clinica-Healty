package clinica.controller.Nuovo;

import java.util.function.Supplier;

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
import clinica.service.impl.FacadeEsame;
@Controller
public class ControllerNuovoEsame {
	@Autowired
	private FacadeEsame facadeEsame;

	@RequestMapping(value="/nuovoEsame", method=RequestMethod.GET)
	public String toNuovoEsame(@ModelAttribute Esame esame){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovoEsame";
		}
		else return"index";
	}


	@RequestMapping(value="/addEsame", method=RequestMethod.POST)
	public String addEsame(@ModelAttribute("esame") @Validated Esame esame, BindingResult result){
		String nextPage=null;
		if(result.hasErrors())
			nextPage  = "nuovoEsame";
		else {
			nextPage="/protected/esameInserito";
		}
//		boolean erroriPresenti = false;
//		String nextPage=null;
//
//		if(esame.getMedico()==null){
//			erroriPresenti=true;
//			model.addAttribute("medicoError", "Campo obbligatorio");
//		}
//		if(esame.getPaziente()==null){
//			erroriPresenti=true;
//			model.addAttribute("pazienteError", "Campo obbligatorio");
//		}
//		if(esame.getTipologiaEsame()==null){
//			erroriPresenti=true;
//			model.addAttribute("tipologiaEsameError", "Campo obbligatorio");
//		}
//		
//		if(erroriPresenti)
//			nextPage  = "nuovoEsame";
//		else {
//			nextPage="/protected/esameInserito";
//		}
		facadeEsame.addEsame(esame);
		return nextPage;   
	}
}