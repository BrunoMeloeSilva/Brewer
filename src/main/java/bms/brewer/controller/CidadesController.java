package bms.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CidadesController {
	
	@RequestMapping("/cidade/novo")
	public String novo() {
		return "cidade/CadastroCidade";
	}
}
