package clinica.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;

import clinica.model.Medico;
import clinica.model.Paziente;
import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeTipologiaEsame;

@Controller
public class ControllerTipologiaEsame {
	@Autowired
	private FacadeTipologiaEsame tipologiaEsameFacade;
	@Autowired
	@Qualifier("tipologiaEsameValidator")
	private Validator validator;
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}	
	@RequestMapping(value="/nuovaTipologiaEsame",method = RequestMethod.GET)
	public String toNuovaTipologiaEsame(@ModelAttribute TipologiaEsame tipologiaEsame){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			return "protected/nuovaTipologiaEsame";
		}
		else return"index";
	}
	@RequestMapping(value="/addTipologiaEsame", method=RequestMethod.POST)
	public String addTipologiaEsame(@RequestParam("num_risultati") int num,@RequestParam("num_requisiti") int num2,@ModelAttribute TipologiaEsame tipologiaEsame,Model model,
			HttpServletRequest request,@Validated TipologiaEsame t,BindingResult bindingResult){
	if(bindingResult.hasFieldErrors() || num<=0){

		model.addAttribute("risultatiError","Riempi tutti i campi");
		return "protected/nuovaTipologiaEsame";
	}
		Map<String, String> requisiti = new HashMap<>();
		requisiti=creaMappaRequisiti(num2,request);
		tipologiaEsame.setRequisiti(requisiti);
		tipologiaEsame.setIndicatoriRisultati(creaListaRisultati(num,request));
		tipologiaEsameFacade.addTipologiaEsame(tipologiaEsame);
		return "/protected/tipologiaEsameInserita";   
	}

	public Map<String, String> creaMappaRequisiti(int numero,HttpServletRequest request){
		Map<String, String> creaMappaRequisiti = new HashMap<>();
		for(int i=1; i<=numero; i++){
			if(request.getParameter("requisito"+i)!="")
				creaMappaRequisiti.put(request.getParameter("requisito"+i), request.getParameter("descrizione_requisito"+i));
		}
		return creaMappaRequisiti;
	}
	@RequestMapping(value="/eliminaTipologiaEsame", method=RequestMethod.POST)
	public String deleteTipologiaEsame(@ModelAttribute TipologiaEsame tipologiaEsame,Model model){
		long id =tipologiaEsame.getIdTipologiaEsame();
		tipologiaEsameFacade.deleteTipologiaEsame(id);
		model.addAttribute("elemento","Tipologia Esame");
		return "protected/eliminazione";
	}
	@RequestMapping(value="/listaTipologiaEsami", method=RequestMethod.GET)
	public String toListaTipologiaEsami(Model model){
		List<TipologiaEsame>lista=(ArrayList<TipologiaEsame>) tipologiaEsameFacade.findAll();
		List<Long> listaId = new ArrayList<>();
		for(TipologiaEsame tipologiaEsame : lista){
			listaId.add(tipologiaEsame.getIdTipologiaEsame());
		}
		TipologiaEsame app = new TipologiaEsame();
		for(long i:listaId){
			app = tipologiaEsameFacade.retrieveTipologiaEsame(i);
			model.addAttribute("requisiti"+i,app.getRequisiti());
		}
		model.addAttribute("lista", lista);
		return "listaTipologiaEsami";

	}

	public List<String> creaListaRisultati(int numero,HttpServletRequest request){
		List<String> listaRisultati=new ArrayList<String>();
		for(int i=1; i<=numero; i++){
			if(request.getParameter("risultato"+i)!="")
				listaRisultati.add(request.getParameter("risultato"+i));}
		return listaRisultati;
	}


}




