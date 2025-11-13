package br.edu.unoesc.monamu.model;

import java.math.BigDecimal;
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
 * Representa o produto no sistema
 */

@Entity
@Table(name = "Produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codpro")
	private Integer id;

	@Column(name = "nompro")
	private String nome;

	@Column(name = "tampro")
	private String tamanho;

	@Column(name = "corpro")
	private String cor;

	@Column(name = "tipro")
	private String tipo;

	@Column(name = "custpro")
	private BigDecimal custo;

	@Column(name = "vendpro")
	private BigDecimal venda;

	@Column(name = "qtdestpro")
	private Integer quantidadeEstoque;

	@Column(name = "datcadpro")
	private LocalDateTime dataCadastro;

	@Column(name = "despro")
	private String descricao;

	@Column(name = "atipro")
	private Boolean ativo;
	
	//revisar??
	@ManyToOne
	@JoinColumn(name = "codfor", referencedColumnName = "codpes", nullable = true)
	private Fornecedor fornecedor;

	@ManyToOne
	@JoinColumn(name = "codloj", nullable = false)
	private Loja loja;

	@ManyToOne
	@JoinColumn(name = "codpes", referencedColumnName = "codpes", nullable = false)
	private Funcionario funcionario;
}
