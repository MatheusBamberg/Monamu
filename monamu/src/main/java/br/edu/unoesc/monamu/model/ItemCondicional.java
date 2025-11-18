package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa a ligação do item no condicional
 */

@Entity
@Table(name = "item_condicional")
public class ItemCondicional {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coditecon")
	private Integer id;
	
	@Column(name = "qtditecon")
	private Integer quantidadeItem;
	
	@ManyToOne
	@JoinColumn(name = "codcnd", nullable = false)
	private Condicional condicional;
	
	@ManyToOne
	@JoinColumn(name = "codpro", nullable = false)
	private Produto produto;

}
