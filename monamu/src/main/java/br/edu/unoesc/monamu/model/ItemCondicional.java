package br.edu.unoesc.monamu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Representa um item dentro de uma condicional.
 */
@Entity
@Table(name = "item_condicional")
public class ItemCondicional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditecon")
    private Integer id;

    /** Quantidade do produto no item condicional. */
    @Column(name = "qtditecon", nullable = false)
    private Integer quantidadeItem;

    /** Condicional à qual este item pertence. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codcnd", nullable = false)
    private Condicional condicional;

    /** Produto que faz parte do item. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codpro", nullable = false)
    private Produto produto;

    // Getters / Setters

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

    public Condicional getCondicional() {
        return condicional;
    }

    public void setCondicional(Condicional condicional) {
        this.condicional = condicional;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
