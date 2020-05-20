package bms.brewer.controller;

import org.springframework.stereotype.Controller;
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
	public String cadastrar(Cerveja cerveja) {
		System.out.println("....Cadastrar: " + cerveja.getSku());
		return "cerveja/CadastroCerveja";
	}

}
