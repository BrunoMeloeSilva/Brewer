package bms.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bms.brewer.model.Estilo;

public interface Estilos extends JpaRepository<Estilo, Long> {
	
}
