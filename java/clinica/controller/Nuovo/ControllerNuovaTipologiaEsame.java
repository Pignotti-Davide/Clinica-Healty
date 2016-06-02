package clinica.controller.Nuovo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import clinica.model.TipologiaEsame;
import clinica.model.Utente;
import clinica.service.impl.FacadeAutenticazione;
import clinica.service.impl.FacadeDati;

@Controller
public class ControllerNuovaTipologiaEsame {
	
	@Autowired
	private FacadeAutenticazione facadeAutenticazione;
	
	@RequestMapping(value="/nuovaTipologiaEsame",method=RequestMethod.POST)
	public String toNTE(@ModelAttribute TipologiaEsame tipologiaEsame){
		return "protected/nuovaTipologiaEsame";
	}
	
	@RequestMapping(value="/addNuovaTipologiaEsame",method=RequestMethod.POST)
	public String addNTE(@ModelAttribute TipologiaEsame tipologiaEsame,Model model){
		
		// gestione della RICHIESTA

		// leggo e manipolo i parametri
		
		String num = request.getParameter("num_requisiti");
		String num1=request.getParameter("num_risultati");
		int numeroRequisiti = Integer.parseInt(num);
		int numeroRisultati=Integer.parseInt(num1);
		
		//  verifico i dati

		boolean erroriPresenti = false;
		String nextPage=null;

		if(nome.equals("")){
			erroriPresenti=true;
			
			model.addAttribute("nomeError", "Campo obbligatorio");
		}
		if(erroriPresenti){
			nextPage  = "/protected/nuovaTipologiaEsame.jsp";
		}
		// tutti i dati corretti
		TipologiaEsame tip = new TipologiaEsame();

	
		tip.setNome(nome);
		tip.setDescrizione(descrizione);
		tip.setPrerequisiti(creaMappaRequisiti(numeroRequisiti,request));
		tip.setIndicatoriRisultati(creaListaRisultati(numeroRisultati, request));
		new FacadeDati().salvaTipologiaEsame(tip);
	
		ServletContext application  = getServletContext();
		HttpSession session= request.getSession();
		session.setAttribute("tip", tip);
		String urlNextPage = response.encodeURL("/protected/tipologiainserita.jsp");
		RequestDispatcher rd = application.getRequestDispatcher(urlNextPage);
		rd.forward(request, response);
		
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
