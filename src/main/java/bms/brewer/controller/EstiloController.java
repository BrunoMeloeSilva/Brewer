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
import bms.brewer.service.exception.NomeEstiloJaCadastradoException;

@Controller
public class EstiloController {
	
	@Autowired
	private EstilosService estilosService;
	
	@RequestMapping("/estilos/novo")
	public ModelAndView novo(Estilo estilo) {
		return new ModelAndView("estilo/CadastroEstilo");
	}
	
	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) { 
			return novo(estilo);
		}
		
		try { 
			estilosService.salvar(estilo); 
		}
		catch(NomeEstiloJaCadastradoException e) {
			bindingResult.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(estilo);
		}
		
		redirectAttributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso");
		return new ModelAndView("redirect:/estilos/novo");
	}
}
