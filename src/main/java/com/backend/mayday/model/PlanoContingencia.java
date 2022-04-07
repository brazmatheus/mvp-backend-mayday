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

import org.hibernate.annotations.ManyToAny;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PLANOCONTINGENCIA")
@NoArgsConstructor
public class PlanoContingencia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	
	@Getter
	@Setter
	@OneToMany(targetEntity = PlanoContingenciaRecurso.class, mappedBy = "planoContingencia")
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PlanoContingenciaRecurso.class, mappedBy = "planoContingencia")
	private List<PlanoContingenciaRecurso> recurso;
	
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PlanoContingenciaAgente.class, mappedBy = "planoContingencia", orphanRemoval = true)
	private List<PlanoContingenciaAgente> agente;

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
//		for (var a : this.agente) {
//			a.setPlanoContingencia(this);
//		}
//		for (var r : this.recurso) {
//			r.setPlanoContingencia(this);
//		}
		return this;
	}
	
	

}
