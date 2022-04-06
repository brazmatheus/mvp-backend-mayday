package com.backend.mayday.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RECURSO")
public class Recurso {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private String idRecurso;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descRecurso;
	
	@OneToOne
	@Getter @Setter
    @JoinColumn(name = "ID_PESSOA", referencedColumnName = "ID")
	private Pessoa pessoa;
	
	@Getter @Setter
	@Column(name="QUANTIDADE")
	private String quantidadeRecurso;
	
	@ManyToMany
	@JoinTable(name="planoContingencia", 
	joinColumns= @JoinColumn(name="planoContingencia_id"),
	inverseJoinColumns= @JoinColumn(name="recurso_id"))
	List<PlanoContingencia> planosContingencia;

}
