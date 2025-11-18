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
 * Representa o item na venda
 */

@Entity
@Table(name = "item_venda")
public class ItemVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coditeven")
	private Integer id;
	
	@Column(name = "qtditeven")
	private Integer quantidadeItem;
	
	@Column(name = "vlruniteven")
	private BigDecimal valorUnitario;

	@Column(name = "vlrtotiteven")
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "codven", nullable = false)
	private Venda venda;

	@ManyToOne
	@JoinColumn(name = "codpro", nullable = false)
	private Produto produto;

}
