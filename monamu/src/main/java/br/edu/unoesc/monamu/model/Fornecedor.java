package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name= "Fornecedor")
@PrimaryKeyJoinColumn(name = "codpes")
public class Fornecedor extends Pessoa {

	@Column(name = "cnpfor", nullable = false, unique = true)
	private String cnpj;
	
	@Column(name= "nomfanfor")
	private String nomeFantasia;


}
