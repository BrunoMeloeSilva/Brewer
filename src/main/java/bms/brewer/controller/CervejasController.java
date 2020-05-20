package bms.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bms.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cerveja/novo")
	public String novo() {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Deu pau ao criar o obj cerveja");
		}else {
		System.out.println("....Cadastrar: " + cerveja.getSku());
		}
		
		return "cerveja/CadastroCerveja";
	}

}

/*** Notas de estudo 
 *
 * public String cadastrar();
 *
 ** Se os dados do post "casarem" com a classe cerveja, é gerado um vinculo para criar o obj é criado automagicamente
 *
 ** BindingResult = Recebe o resultado da execucao de criar o obj cerveja pelo post
 *
****/