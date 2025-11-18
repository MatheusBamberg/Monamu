package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Venda;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
	
}
