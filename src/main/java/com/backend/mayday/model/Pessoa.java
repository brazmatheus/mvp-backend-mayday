package com.backend.mayday.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PESSOA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Pessoa {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private String cpf;

	@Getter @Setter
	@NotNull
	@Column(name="NOME")
	private String nome;
	
	@Getter @Setter
	@Column(name="TELEFONE")
	private String telefone;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CARGO")
	private Cargo cargo;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CIDADE")
	private Cidade cidade;
	
	@ManyToMany(mappedBy = "agentes")
	private List<PlanoAtivacao> planoAtivacao;

}
