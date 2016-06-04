package clinica.controller.Nuovo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.Esame;
import clinica.model.TipologiaEsame;
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
	public String addEsame(@ModelAttribute Esame esame,@PathVariable("dataEsame")String data,Model model){
		String nextPage=null;
		boolean erroriPresenti = false;
		if(esame.getMedico()==null){
			erroriPresenti=true;
			model.addAttribute("medicoError", "Campo obbligatorio");
		}
		if(!(isValidDate(data))){
			model.addAttribute("dataError", "Data non valida");
		}
		if(esame.getPaziente()==null){
			erroriPresenti=true;
			model.addAttribute("pazienteError", "Campo obbligatorio");
		}
		if(esame.getTipologiaEsame()==null){
			erroriPresenti=true;
			model.addAttribute("tipologiaEsameError", "Campo obbligatorio");
		}
		
		if(erroriPresenti)
			nextPage  = "nuovoEsame";
		else {
			nextPage="/protected/esameInserito";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		dateFormat.format(date);
		esame.setPrenotazione(date);
		facadeEsame.addEsame(esame);
		return nextPage;   
	}
	 public  boolean isValidDate(String inDate) {
		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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