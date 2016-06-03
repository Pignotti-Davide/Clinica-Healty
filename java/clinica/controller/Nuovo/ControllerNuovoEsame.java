package clinica.controller.Nuovo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import clinica.model.Esame;
import clinica.service.impl.FacadeEsame;

@Controller
@RequestMapping("/nuovoEsame")
public class ControllerNuovoEsame {

	@Autowired
	private FacadeEsame esameFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String listaTipologiaEsame(ModelMap model) {
		model.addAttribute("listaEsame", esameFacade.listaEsame());
		return "esame";
	}

	@RequestMapping(value = "/aggiungiEsame", method = RequestMethod.GET)
	public ModelAndView aggiungiTipologiaEsame(ModelMap model) {
		return new ModelAndView("aggiungiEsame", "command", new Esame());
	}

	@RequestMapping(value = "/Esame", method = RequestMethod.POST)
	public String updateEsame(
			@ModelAttribute("esameform")Esame Esame, ModelMap model) {
		this.esameFacade.insertEsame(Esame);
		model.addAttribute("EsameList", esameFacade.listaEsame());
		return "esame";
	}

	@RequestMapping(value = "/delete/{tipId}", method = RequestMethod.GET)
	public String deleteEsame(@PathVariable("tipId") Integer esaId,
			ModelMap model) {
		this.esameFacade.deleteEsame(esaId);
		model.addAttribute("listaTipologiaEsame", esameFacade.listaEsame());
		return "esame";
	}
}