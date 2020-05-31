package bms.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import bms.brewer.model.Estilo;


public interface Estilos extends JpaRepository<Estilo, Long> {
	
	//Basta especificar o metodo aqui, que ele será automagicamente implementado !
	//Mas o padrão de especificação deve ser seguido: findBy<nome>IgnoreCase
	public Optional<Estilo> findByNomeIgnoreCase(String nome);
	
}
