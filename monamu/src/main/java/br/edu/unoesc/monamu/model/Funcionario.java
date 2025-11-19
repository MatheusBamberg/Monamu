package br.edu.unoesc.monamu.model;

import java.time.LocalDateTime;

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
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "codpes")
public class Funcionario extends Pessoa {

	/**
	 * Número de Cadastro de Pessoa Física (CPF) do funcionário.
	 */
	@Column(name = "cpffun", length = 14, nullable = false, unique = true) // 11 dígitos + formatação
	private String cpf;

	/**
	 * Cargo ou função do funcionário na loja.
	 */
	@Column(name = "carfun", length = 50)
	private String cargo;

	/**
	 * Data de admissão do funcionário na loja.
	 */
	@Column(name = "datadmfun")
	private LocalDateTime dataAdmissao;

	/**
	 * Senha de acesso do funcionário ao sistema (idealmente armazenada de forma segura/hash).
	 */
	@Column(name = "senfun", length = 60) // Comprimento para hash (ex: bcrypt)
	private String senha;

	/**
	 * Loja a qual o funcionário está vinculado.
	 */
	@ManyToOne
	@JoinColumn(name = "codloj", nullable = false)
	private Loja loja;

	// --- Getters e Setters ---

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public LocalDateTime getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDateTime dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
}