package bms.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bms.brewer.model.Cerveja;
import bms.brewer.model.Origem;
import bms.brewer.model.Sabor;
import bms.brewer.repository.Estilos;
import bms.brewer.service.CervejasService;

@Controller
public class CervejasController {
	
	@Autowired
	Estilos estilos;
	
	@Autowired
	CervejasService cervejasService;
	
	@RequestMapping("/cerveja/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView modelAndView = new ModelAndView("cerveja/CadastroCerveja");
		modelAndView.addObject("sabores", Sabor.values());
		modelAndView.addObject("estilos", estilos.findAll());
		modelAndView.addObject("origens", Origem.values());
		return modelAndView;
	}
	
	@RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Teve erro no bindingResult: " + bindingResult.getAllErrors());
			//System.out.println("Erro ao criar obj cerveja: " + cerveja.toString());
			return novo(cerveja);
		}else {
			cervejasService.salvar(cerveja);
			ModelAndView modelAndView = new ModelAndView("redirect:/cerveja/novo");
			redirectAttributes.addFlashAttribute("mensagem", "Cerveja cadastrada com sucesso.");
			return modelAndView;
		}
		
		
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
 ** "redirect:/cerveja/novo" -> retorna para o requisitante(ex.: Navegador) o endereço para o qual ele deve fazer uma nova chamada
 *								ele faz a chamada para outro RequestMapping que contenha o endereco especificado
 *
 ** redirectAttributes.addFlashAttribute("mensagem", "Deu pau ao criar o obj cerveja"); 
 *			-> Cria um atributo a ser enviado no redirecionamento, assim ele pode ser manipulado pelo Thymeleaf para 
 *				montar o html. RedirectAttributes é especifico para passar objetos quando se faz re-direcionamento,
 *				se você usar o Model não irá funcionar, pois o model só funciona para direcionamento (forward).
 *
 ** model.addAttribute("mensagem", "Cadastrado com sucesso...");
 *			-> Cria um atributo a ser enviado no direcionamento(Forward), assim o obj pode ser manipulado pelo Thymeleaf
 *				para montar o html. Model é especifico para passagem de atributos no direcionamento, se fosse
 *				re-direcionamento deveria-se usar o RedirectAttributes.
 ** return "redirect:/cerveja/novo";
 *			-> O bindingResult não é passado no redirect, pois é o navegador que faz a nova requisicao para o novo endereço informado no redirect,
 *				e ao fazer isso, ele faz um get novo, o erro de validação do obj cerveja ocorre normalmente antes do 
 *				<return "redirect:/cerveja/novo";> mas fica no metodo seu conteudo e uma ordem para uma nova requisicao é enviada ao requisitante,
 *				por esse motivo, ao usar redirect o "${#fields.hasAnyErrors()}" nunca muda de valor.
****/
