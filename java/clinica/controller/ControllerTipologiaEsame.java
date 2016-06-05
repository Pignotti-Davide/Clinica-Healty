package clinica.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;

import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeTipologiaEsame;

@Controller
public class ControllerTipologiaEsame {
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
	public String addTipologiaEsame(@RequestParam("num_risultati") int num,@RequestParam("num_requisiti") int num2,@ModelAttribute TipologiaEsame tipologiaEsame,Model model,
			HttpServletRequest request){

		boolean erroriPresenti = false;
		String nextPage=null;
		Map<String, String> requisiti = new HashMap<>();
		requisiti=creaMappaRequisiti(num2,request);
		tipologiaEsame.setRequisiti(requisiti);
		tipologiaEsame.setIndicatoriRisultati(creaListaRisultati(num,request));
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
	@RequestMapping(value="/eliminaTipologiaEsame/{id}",method = RequestMethod.GET)
	public String deleteTipologiaEsame(@PathVariable("id")long Id,@ModelAttribute TipologiaEsame tipologiaEsame){
		//		tipologiaEsameFacade.deleteTipologiaEsame(Id);
		return "index";
	}
	@RequestMapping(value="/listaTipologiaEsami", method=RequestMethod.GET)
	public String toListaTipologiaEsami(@ModelAttribute("lista") ArrayList<TipologiaEsame> lista){
		lista=(ArrayList<TipologiaEsame>) tipologiaEsameFacade.findAll();
		for (TipologiaEsame tipologiaEsame : lista) {
			System.out.println(tipologiaEsame.getNome());
		}
		return "listaTipologiaEsami";
		
	}
	
	public List<String> creaListaRisultati(int numero,HttpServletRequest request){
		List<String> listaRisultati=new ArrayList<String>();
		for(int i=1; i<=numero; i++)
			listaRisultati.add(request.getParameter("risultato"+i));
		return listaRisultati;
	}
	
	

}

