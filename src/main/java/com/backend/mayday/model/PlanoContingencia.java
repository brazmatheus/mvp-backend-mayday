package com.backend.mayday.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PLANOCONTINGENCIA")
public class PlanoContingencia {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private Integer idPlanoContingencia;

	@Getter @Setter
	@Column(name="TITULO")
	private String tituloPlanoContingencia;
	
	@Getter @Setter
	@Column(name="SUBTITULO")
	private String subtituloPlanoContingencia;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descPlanoContingencia;
	
	@Getter @Setter
	@Column(name="COMUNICACAOALTERNATIVA")
	private String comunicacaoAlternativaPlanoContingencia;

	@Getter @Setter
	@Column(name="HISTORICOEVENTOS")
	private String historicoEventosPlanoContingencia;
	
	@Getter @Setter
	@OneToMany(targetEntity = Tags.class , mappedBy = "planoContingencia")
	private List<Tags> tags;
	
	@Getter @Setter
	@ManyToMany(mappedBy = "planosContingencia")
	private List<Recurso> recursos;
	

}