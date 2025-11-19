package br.edu.unoesc.monamu.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Representa a ligação (item) de um {@link Produto} dentro de uma {@link Condicional}.
 */
@Entity
@Table(name = "item_condicional")
public class ItemCondicional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coditecon")
    private Integer id;

    @NotNull
    @Min(1)
    @Column(name = "qtditecon", nullable = false)
    private Integer quantidadeItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codcnd", nullable = false)
    private Condicional condicional;

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

    // equals / hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemCondicional)) return false;
        ItemCondicional that = (ItemCondicional) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

