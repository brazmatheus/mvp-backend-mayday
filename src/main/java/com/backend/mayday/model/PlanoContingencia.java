package com.backend.mayday.model;

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
@Table(name = "PLANOCONTINGENCIA")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class PlanoContingencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "planoContingencia")
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

//	public PlanoContingencia() {
//		this.tituloPlanoContingencia = "Digite um Título aqui:";
//		this.subtituloPlanoContingencia = "Digite um Subtítulo aqui:";
//		this.descPlanoContingencia = "Digite a descrição do plano aqui:";
//		this.historicoEventosPlanoContingencia = "Digite o histórico de eventos";
//		this.comunicacaoAlternativaPlanoContingencia = "Digite as comunicações alternativas";
//	}
	
	public PlanoContingencia withLinkedTags() {
		for (var tag : this.tags) {
			tag.setPlanoContingencia(this);
		}
		return this;
	}

}
