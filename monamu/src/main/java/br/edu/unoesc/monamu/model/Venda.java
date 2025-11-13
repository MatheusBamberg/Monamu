package br.edu.unoesc.monamu.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Representa a venda no sistema
 */

@Entity
@Table(name= "Venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codven")
	private Integer id;
	
	@Column(name = "datven")
	private LocalDateTime dataVenda;
	
	@Column(name= "totven")
	private BigDecimal totalVenda;
	
	@Column(name = "fompagven")
	private String formaPagamento;
	
	@Column(name= "cupdscven")
	private BigDecimal cupomDesconto;
	
    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemVenda> itens;
	
	// falta os codpes

}
