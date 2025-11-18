package br.edu.unoesc.monamu.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa a opção de desconto no sistema
 */
@Entity
@Table(name = "desconto")
public class Desconto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coddsc")
	private Integer id;

	@Column(name = "nomdsc")
	private String nome;

	@Column(name = "valdsc")
	private BigDecimal valor;
	
	@Column(name = "caddsc")
	private LocalDateTime dataCadastro;

	@Column(name = "vlddsc")
	private LocalDate dataValidade;
	
	@ManyToOne
	@JoinColumn(name = "codven", nullable = false)
	private Venda venda;
}
