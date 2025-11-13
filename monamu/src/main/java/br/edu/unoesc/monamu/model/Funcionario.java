package br.edu.unoesc.monamu.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Representa um funcionário no sistema, herdando os atributos de {@link Pessoa}
 */

@Entity
@Table(name = "Funcionario")
@PrimaryKeyJoinColumn(name = "codpes")
public class Funcionario extends Pessoa {

	@Column(name = "cpffun", nullable = false, unique = true)
	private String cpf;

	@Column(name = "carfun")
	private String cargo;

	@Column(name = "datadmfun")
	private Date dataAdmissao;

	@Column(name = "senfun")
	private String senha;

	@ManyToOne
	@JoinColumn(name = "codloj", nullable = false)
	private Loja loja;

}
