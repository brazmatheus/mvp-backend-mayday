package com.backend.mayday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private Integer cpf;

	@Getter @Setter
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@Getter @Setter
	@Column(name="TELEFONE")
	private String telefone;
	
	@OneToOne(mappedBy = "responsavel")
	private Recurso recurso;

}
