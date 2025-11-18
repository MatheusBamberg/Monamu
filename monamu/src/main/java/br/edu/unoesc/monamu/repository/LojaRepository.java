package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Loja;

public interface LojaRepository extends JpaRepository<Loja, Integer> {
	
}
