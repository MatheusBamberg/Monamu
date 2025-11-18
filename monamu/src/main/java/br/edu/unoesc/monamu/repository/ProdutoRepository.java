package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
