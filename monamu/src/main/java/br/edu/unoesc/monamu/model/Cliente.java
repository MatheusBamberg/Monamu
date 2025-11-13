package br.edu.unoesc.monamu.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

/**
 * Representa um cliente no sistema, herdando atributos de {@link Pessoa}
 */

@Entity
@Table(name= "Cliente")
@PrimaryKeyJoinColumn(name = "codpes")
public class Cliente extends Pessoa {
	
	@Column(name = "cpfcli", nullable = false, unique = true)
	private String cpf;
	
	@Column(name= "datcadcli")
	private LocalDateTime dataCadastro;

}
