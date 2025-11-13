package br.edu.unoesc.monamu.model;

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
 * Representa a opção condicional no sistema
 */

@Entity
@Table(name = "Condicional")
public class Condicional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codcnd")
	private Integer id;
	
	@Column(name = "nomitncon")
	private String nomeItem;
	
	@Column(name = "datretitncon")
	private LocalDateTime dataRetirada;
	
	@Column(name = "datdevitncon")
	private LocalDateTime dataDevolucao;
	
	@Column(name = "obsitncon")
	private String observacao;
	
	// tem um codcli?
	
	@ManyToOne
	@JoinColumn(name = "codpes", referencedColumnName = "codpes", nullable = false)
	private Cliente cliente;

}
