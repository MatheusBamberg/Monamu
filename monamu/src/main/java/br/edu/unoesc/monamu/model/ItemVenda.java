package br.edu.unoesc.monamu.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa um item dentro de uma venda.
 */
@Entity
@Table(name = "item_venda")
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coditeven")
	private Integer id;
	
	/** Quantidade do produto vendida. */
	@Column(name = "qtditeven", nullable = false)
	private Integer quantidadeItem;
	
	/** Valor unitário do produto na venda. */
	@Column(name = "vlruniteven", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorUnitario;

	/** Valor total do item (quantidade * valorUnitario). */
	@Column(name = "vlrtotiteven", precision = 10, scale = 2, nullable = false)
	private BigDecimal valorTotal;
	
	/** Venda à qual este item pertence. */
	@ManyToOne
	@JoinColumn(name = "codven", nullable = false)
	private Venda venda;

	/** Produto vendido. */
	@ManyToOne
	@JoinColumn(name = "codpro", nullable = false)
	private Produto produto;

	// --- Getters e Setters ---

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidadeItem() {
		return quantidadeItem;
	}

	public void setQuantidadeItem(Integer quantidadeItem) {
		this.quantidadeItem = quantidadeItem;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
