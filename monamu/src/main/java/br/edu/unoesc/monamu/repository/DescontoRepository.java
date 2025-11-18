package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Desconto;

public interface DescontoRepository extends JpaRepository<Desconto, Integer> {
	
}
