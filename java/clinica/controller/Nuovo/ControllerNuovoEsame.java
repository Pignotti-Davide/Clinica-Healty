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
@RequestMapping("/esame")
public class ControllerNuovoEsame {

	@Autowired
	private FacadeEsame esameFacade;

	@RequestMapping(method = RequestMethod.GET)
	public String listaTipologiaEsame(ModelMap model) {
		model.addAttribute("esame", esameFacade.listaEsame());
		return "esame";
	}

	@RequestMapping(value = "/aggiungiEsame", method = RequestMethod.GET)
	public ModelAndView aggiungiEsame(ModelMap model) {
		return new ModelAndView("aggiungiEsame", "command", new Esame());
	}

	@RequestMapping(value = "/updateEsame", method = RequestMethod.POST)
	public String updateEmployee(
			@ModelAttribute("esameform")Esame esame, ModelMap model) {
		this.esameFacade.insertEsame(esame);
		model.addAttribute("employeesList", esameFacade.listaEsame());
		return "employee";
	}

	@RequestMapping(value = "/delete/{esaId}", method = RequestMethod.GET)
	public String deleteTipologiaEsame(@PathVariable("esaId") Integer empId,
			ModelMap model) {
		this.esameFacade.deleteEsame(empId);
		model.addAttribute("listaEsame", esameFacade.listaEsame());
		return "esame";
	}
}