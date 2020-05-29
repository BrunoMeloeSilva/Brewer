package bms.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bms.brewer.model.Cerveja;

public interface Cervejas extends JpaRepository<Cerveja, Long>{

}
