package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa uma pessoa no sistema e é usada como base para outras classes
 */

@Entity
@Table(name= "Pessoa")
public class Pessoa {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codpes")
	private Integer id;
	
	@Column(name= "nompes")
	private String nome;
	
	@Column(name= "emapes", nullable = false, unique = true)
	private String email;
	
	@Column(name= "sexpes")
	private char sexo;
	
	@Column(name= "telpes")
	private String telefone;
	
	@Column(name= "ruapes")
	private String rua;
	
	@Column(name= "baipes")
	private String bairro;
	
	@Column(name= "cidpes")
	private String cidade;
	
	@Column(name= "estpes")
	private String estado;
	
}
