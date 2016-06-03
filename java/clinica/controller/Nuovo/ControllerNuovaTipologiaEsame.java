package clinica.controller.Nuovo;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeTipologiaEsame;

@Controller
public class ControllerNuovaTipologiaEsame {
	@Autowired
	private FacadeTipologiaEsame tipologiaEsameFacade;

	@RequestMapping(value="/nuovaTipologiaEsame",method = RequestMethod.GET)
	public String toNuovaTipologiaEsame(@ModelAttribute TipologiaEsame tipologiaEsame){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovaTipologiaEsame";
		}
		else return"index";
	}
	@RequestMapping(value="/addTipologiaEsame", method=RequestMethod.POST)
	public String addTipologiaEsame(@ModelAttribute TipologiaEsame tipologiaEsame,Model model){
	
		boolean erroriPresenti = false;
		String nextPage=null;

		if(tipologiaEsame.getNome().equals("")){
			erroriPresenti=true;
			model.addAttribute("nomeError", "Campo obbligatorio");
		}
		if(tipologiaEsame.getDescrizione().equals("")){
			erroriPresenti=true;
			model.addAttribute("descrizioneError", "Campo obbligatorio");
		}
		
		if(erroriPresenti)
			nextPage  = "nuovaTipologiaEsame";
		else {
		nextPage="/protected/tipologiaEsameInserita";
		
		tipologiaEsameFacade.addTipologiaEsame(tipologiaEsame);
		}
		return nextPage;   
	}
	public Map<String, String> creaMappaRequisiti(int numero,HttpServletRequest request){
		Map<String, String> creaMappaRequisiti = new HashMap<>();
		for(int i=1; i<=numero; i++)
			creaMappaRequisiti.put(request.getParameter("requisito"+i), request.getParameter("descrizione_requisito"+i));
		return creaMappaRequisiti;
	}
	
	public List<String> creaListaRisultati(int numero,HttpServletRequest request){
		List<String> listaRisultati=new ArrayList<String>();
		for(int i=1; i<=numero; i++)
		listaRisultati.add(request.getParameter("risultato"+i));
		return listaRisultati;
	}

}

