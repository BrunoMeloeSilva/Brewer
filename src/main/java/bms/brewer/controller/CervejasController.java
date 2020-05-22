package bms.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import bms.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	@RequestMapping("/cerveja/novo")
	public String novo(Cerveja cerveja) {
		return "cerveja/CadastroCerveja";
	}
	
	@RequestMapping(value = "/cerveja/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
		
		if(bindingResult.hasErrors()) {
			//redirectAttributes.addFlashAttribute("mensagem", "Deu pau ao criar o obj cerveja");
			//return "redirect:/cerveja/novo";
			
			//return "cerveja/CadastroCerveja";
			
			//com essa chamada, fica mais organizado, ao invés de usar a linha acima..
			return novo(cerveja);
		}else {
			model.addAttribute("mensagem", "Cadastrado com sucesso a cerveja de código: " + cerveja.getSku());
			return "cerveja/CadastroCerveja"; 
		}
		
		
	}
	
	@RequestMapping("/cerveja/novo2")
	public String novo2(Cerveja cerveja) {
		return "cerveja/cadastro-produto";
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
