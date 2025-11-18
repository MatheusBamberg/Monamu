package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
