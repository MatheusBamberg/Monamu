package br.edu.unoesc.monamu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.monamu.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
	
}
