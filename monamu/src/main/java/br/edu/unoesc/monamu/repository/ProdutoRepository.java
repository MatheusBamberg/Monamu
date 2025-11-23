package br.edu.unoesc.monamu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	  List<Produto> findByQuantidadeEstoqueGreaterThan(int quantidadeEstoque);

	    List<Produto> findByQuantidadeEstoqueLessThanEqual(int quantidadeEstoque);

	    long countByQuantidadeEstoqueGreaterThan(int quantidadeEstoque);
}
