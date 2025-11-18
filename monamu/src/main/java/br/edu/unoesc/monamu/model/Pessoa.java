package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

/**
 * Representa uma pessoa no sistema e é usada como base para outras classes
 */

@Entity
@Table(name= "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codpes")
	protected Integer id;
	
	@Column(name= "nompes", length = 80, nullable = false)
	protected String nome;
	
	@Column(name= "emapes", length = 80, nullable = false, unique = true)
	protected String email;
	
	@Column(name= "sexpes", length = 1, nullable = false)
	protected Character sexo;
	
	@Column(name= "telpes", length = 20, nullable = false)
	protected String telefone;
	
	@Column(name= "ruapes", length = 100, nullable = false)
	protected String rua;
	
	@Column(name= "baipes", length = 20, nullable = false)
	protected String bairro;
	
	@Column(name= "cidpes", length = 50, nullable = false)
	protected String cidade;
	
	@Column(name= "estpes", length = 20, nullable = false)
	protected String estado;
	
}
