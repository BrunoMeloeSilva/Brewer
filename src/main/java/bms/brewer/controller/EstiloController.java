package bms.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bms.brewer.model.Estilo;
import bms.brewer.service.EstilosService;

@Controller
public class EstiloController {
	
	@Autowired
	private EstilosService estilosService;
	
	@RequestMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(estilo);
		}
		
		estilosService.salvar(estilo);
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");
	}
}
