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
 * Representa uma transação de venda.
 */
@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codven")
	private Integer id;

	/** Data e hora da venda. */
	@Column(name = "datven", nullable = false)
	private LocalDateTime dataVenda;

	/** Valor total da venda. */
	@Column(name = "totven", precision = 10, scale = 2, nullable = false)
	private BigDecimal totalVenda;

	/** Forma de pagamento. */
	@Column(name = "fompagven", length = 50, nullable = false)
	private String formaPagamento;

	/** Valor de desconto por cupom. */
	@Column(name = "cupdscven", precision = 10, scale = 2)
	private BigDecimal valorCupomDesconto;

	/** Cliente que realizou a compra. */
	@ManyToOne
	@JoinColumn(name = "codcli", nullable = false)
	private Cliente cliente;

	/** Funcionário que realizou a venda. */
	@ManyToOne
	@JoinColumn(name = "codfun", nullable = false)
	private Funcionario funcionario;

	// --- Getters e Setters ---

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getTotalVenda() {
		return totalVenda;
	}

	public void setTotalVenda(BigDecimal totalVenda) {
		this.totalVenda = totalVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValorCupomDesconto() {
		return valorCupomDesconto;
	}

	public void setValorCupomDesconto(BigDecimal valorCupomDesconto) {
		this.valorCupomDesconto = valorCupomDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
