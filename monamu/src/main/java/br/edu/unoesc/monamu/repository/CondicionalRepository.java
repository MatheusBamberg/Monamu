package br.edu.unoesc.monamu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Condicional;

public interface CondicionalRepository extends JpaRepository<Condicional, Integer> {
	 long countByDevolvidoFalse();
	 
	 List<Condicional> findByDataDevolucaoBetweenAndDevolvidoFalse(LocalDateTime inicio, LocalDateTime fim);

}
