package com.backend.mayday.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PLANOATIVACAO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class PlanoAtivacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -900181837811828652L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Getter @Setter
	@Column(name="ID")
	private Integer id;

	@Getter @Setter
	@Column(name="TITULO")
	private String titulo;
	
	@Getter @Setter
	@Column(name="SUBTITULO")
	private String subtitulo;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Getter @Setter
	@Column(name="COMUNICACAOALTERNATIVA")
	private String comunicacaoAlternativa;

	@Getter @Setter
	@Column(name="HISTORICOEVENTOS")
	private String historicoEventos;
	
	@Getter @Setter
	@Column(name="DANOS")
	private String danos;
	
	@Getter @Setter
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "planoAtivacao")
	private List<Tags> tags;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="PlanosAgentes", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"planosContingencia_id", "agentes_id"}), 
	joinColumns = @JoinColumn(name = "agentes_id"),
	inverseJoinColumns = @JoinColumn(name = "planosContingencia_id"))
	@Getter @Setter
	private List<Pessoa> agentes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="PlanosRecursos", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"planosContingencia_id", "recursos_id"}), 
	joinColumns = @JoinColumn(name = "recursos_id"),
	inverseJoinColumns = @JoinColumn(name = "planosContingencia_id"))
	@Getter @Setter
	private List<Recurso> recursos;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CIDADE")
	private Cidade cidade;
	
	@Getter @Setter
	@OneToMany(cascade = CascadeType.ALL, targetEntity = PontosInteresse.class ,mappedBy = "planoAtivacao")
	private List<PontosInteresse> pontoInteresse;

	public PlanoAtivacao planoAtivacaoDefault() {
		this.titulo = "Digite um Título aqui:";
		this.subtitulo = "Digite um Subtítulo aqui:";
		this.descricao = "Digite a descrição do plano aqui:";
		this.historicoEventos = "Digite o histórico de eventos";
		this.comunicacaoAlternativa = "Digite as comunicações alternativas";
		this.danos = "Digite os danos";
		return this;
	}
	
	public PlanoAtivacao withLinkedTags() {
		for (var tag : this.tags) {
			tag.setPlanoAtivacao(this);
		}
		return this;
	}

}
