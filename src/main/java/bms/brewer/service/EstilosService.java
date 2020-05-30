package bms.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bms.brewer.model.Estilo;
import bms.brewer.repository.Estilos;

@Service
public class EstilosService {
	
	@Autowired
	Estilos estilos;
	
	public void salvar(Estilo estilo) {
		this.estilos.save(estilo);
	}
}
