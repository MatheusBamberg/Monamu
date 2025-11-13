package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa a loja no sistema
 */

@Entity
@Table(name = "Loja")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codloj")
	private Integer id;

	@Column(name = "nomloj")
	private String nome;

	@Column(name = "rualoj")
	private String rua;

	@Column(name = "bailoj")
	private String bairro;

	@Column(name = "cidloj")
	private String cidade;

	@Column(name = "telloj")
	private String telefone;

	@Column(name = "cnploj")
	private String cnpj;

}
