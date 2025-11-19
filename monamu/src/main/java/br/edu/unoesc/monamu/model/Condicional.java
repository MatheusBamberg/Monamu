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
 * Representa uma transação de envio de mercadoria "Condicional".
 */
@Entity
@Table(name = "condicional")
public class Condicional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codcnd")
	private Integer id;
	
	/** Nome/Identificador da condicional. */
	@Column(name = "nomitncon", length = 100)
	private String nomeItem;
	
	/** Data e hora da retirada. */
	@Column(name = "datretitncon", nullable = false)
	private LocalDateTime dataRetirada;
	
	/** Data e hora da devolução. */
	@Column(name = "datdevitncon")
	private LocalDateTime dataDevolucao;
	
	/** Observações. */
	@Column(name = "obsitncon", length = 255)
	private String observacao;
	
	/** Cliente que retirou a condicional. */
	@ManyToOne
	@JoinColumn(name = "codcli", nullable = false)
	private Cliente cliente;

	// --- Getters e Setters ---

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public LocalDateTime getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDateTime dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDateTime getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDateTime dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
