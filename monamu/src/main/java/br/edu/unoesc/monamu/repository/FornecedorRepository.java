package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {
	
}
