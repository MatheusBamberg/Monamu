package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Representa um fornecedor.
 */
@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "codpes")
public class Fornecedor extends Pessoa {

	/** CNPJ do fornecedor. */
	@Column(name = "cnpfor", length = 18, nullable = false, unique = true)
	private String cnpj;

	/** Nome fantasia do fornecedor. */
	@Column(name = "nomfanfor", length = 100)
	private String nomeFantasia;

	// --- Getters e Setters ---

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}