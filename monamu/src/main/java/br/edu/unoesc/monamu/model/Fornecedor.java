package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Representa um fornecedor no sistema, herdando atributos de {@link Pessoa}
 */
@Entity
@Table(name = "fornecedor")
@PrimaryKeyJoinColumn(name = "codpes")
public class Fornecedor extends Pessoa {

	@Column(name = "cnpfor", nullable = false, unique = true)
	private String cnpj;

	@Column(name = "nomfanfor")
	private String nomeFantasia;
}
