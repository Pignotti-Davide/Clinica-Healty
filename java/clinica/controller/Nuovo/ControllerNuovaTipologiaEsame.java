package clinica.controller.Nuovo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import clinica.model.TipologiaEsame;
import clinica.service.impl.FacadeTipologiaEsame;

@Controller
@RequestMapping("/tipologiaEsame")
public class ControllerNuovaTipologiaEsame {

	@Autowired
	private FacadeTipologiaEsame tipologiaEsameFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String listaTipologiaEsame(ModelMap model) {
		model.addAttribute("listaTipologiaEsame", tipologiaEsameFacade.listaTipologiaEsame());
		return "tipologiaEsame";
	}

	@RequestMapping(value = "/aggiungiTipologiaEsame", method = RequestMethod.GET)
	public ModelAndView aggiungiTipologiaEsame(ModelMap model) {
		return new ModelAndView("aggiungiTipologiaEsame", "command", new TipologiaEsame());
	}

	@RequestMapping(value = "/updateTipologiaEsame", method = RequestMethod.POST)
	public String updateEmployee(
			@ModelAttribute("tipologiaEsameform")TipologiaEsame tipologiaEsame, ModelMap model) {
		this.tipologiaEsameFacade.insertTipologiaEsame(tipologiaEsame);
		model.addAttribute("employeesList", tipologiaEsameFacade.listaTipologiaEsame());
		return "employee";
	}

	@RequestMapping(value = "/delete/{tipId}", method = RequestMethod.GET)
	public String deleteTipologiaEsame(@PathVariable("tipId") Integer empId,
			ModelMap model) {
		this.tipologiaEsameFacade.deleteTipologiaEsame(empId);
		model.addAttribute("listaTipologiaEsame", tipologiaEsameFacade.listaTipologiaEsame());
		return "employee";
	}
}

