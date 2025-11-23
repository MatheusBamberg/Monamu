package br.edu.unoesc.monamu.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Representa um funcionário.
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "codpes")
public class Funcionario extends Pessoa {

    /** CPF do funcionário. */
    @Column(name = "cpffun", length = 14, nullable = false, unique = true)
    private String cpf;

    /** Cargo ou função. */
    @Column(name = "carfun", length = 50)
    private String cargo;

    /** Data de admissão. */
    @Column(name = "datadmfun")
    private LocalDateTime dataAdmissao;

    /** Senha (esperada como hash). */
    @Column(name = "senfun", length = 60)
    private String senha;

    /** Loja à qual está vinculado. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codloj", nullable = false)
    private Loja loja;

    //Pro login
    @OneToOne(mappedBy = "funcionario")
    private Usuario usuario;


    public Funcionario() {
    	
    }
    
    public Funcionario(Integer id, String nome, String email, Character sexo, String telefone, String rua,
			String bairro, String cidade, String estado, String cpf, String cargo, LocalDateTime dataAdmissao,
			String senha, Loja loja) {
		super(id, nome, email, sexo, telefone, rua, bairro, cidade, estado);
		this.cpf = cpf;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
		this.senha = senha;
		this.loja = loja;
	}

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
}
