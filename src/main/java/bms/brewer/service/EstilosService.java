package bms.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bms.brewer.model.Estilo;
import bms.brewer.repository.Estilos;
import bms.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class EstilosService {
	
	@Autowired
	Estilos estilos;
	
	public Estilo salvar(Estilo estilo) {
		
		Optional<Estilo> findByNomeIgnoreCase = estilos.findByNomeIgnoreCase(estilo.getNome());
		
		if(findByNomeIgnoreCase.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Nome do estilo já cadastrado");
		}
		
		return this.estilos.saveAndFlush(estilo);
		//Para salvar e retornar o ID
	}
}
