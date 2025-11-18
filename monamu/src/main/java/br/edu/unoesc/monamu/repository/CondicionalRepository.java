package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Condicional;

public interface CondicionalRepository extends JpaRepository<Condicional, Integer> {
	
}
