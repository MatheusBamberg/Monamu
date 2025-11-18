package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.ItemVenda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {
	
}
