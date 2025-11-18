package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
}
