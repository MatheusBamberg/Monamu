package br.edu.unoesc.monamu.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Representa um funcionário no sistema, herdando os atributos de {@link Pessoa}.
 *
 * Observação: Presumo que Pessoa seja uma entidade mapeada com estratégia JOINED.
 * Se sua hierarquia for diferente ajuste as anotações de herança em Pessoa.
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "codpes")
public class Funcionario extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * CPF armazenado sem formatação (somente dígitos). Ex.: 11111111111
     */
    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    @Column(name = "cpffun", length = 11, nullable = false, unique = true)
    private String cpf;

    @Size(max = 50)
    @Column(name = "carfun", length = 50)
    private String cargo;

    @Column(name = "datadmfun")
    private LocalDateTime dataAdmissao;

    /**
     * Senha já esperada como hash (ex: bcrypt). Comprimento 60 cobre bcrypt.
     */
    @Size(max = 60)
    @Column(name = "senfun", length = 60)
    private String senha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codloj", nullable = false)
    private Loja loja;

    // Getters / Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public LocalDateTime getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDateTime dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    // equals / hashCode (baseado em id herdado de Pessoa)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
