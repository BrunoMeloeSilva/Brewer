package bms.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bms.brewer.model.Cerveja;
import bms.brewer.repository.Cervejas;

@Service
public class CervejasService {
	
	@Autowired
	Cervejas cervejas;
	
	public void salvar(Cerveja cerveja) {
		this.cervejas.save(cerveja);
	}
}
