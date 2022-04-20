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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RECURSO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recurso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	@Column(name="ID")
	private Integer idRecurso;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descRecurso;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Getter @Setter
    @JoinColumn(name = "ID_RESPONSAVEL", referencedColumnName = "ID")
	private Pessoa responsavel;
	
	@Getter @Setter
	@Column(name="QUANTIDADE")
	private String quantidade;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name="PlanosRecursos", 
	uniqueConstraints = @UniqueConstraint(columnNames = {"planosContingencia_id", "recursos_id"}), 
	joinColumns = @JoinColumn(name = "planosContingencia_id"),
	inverseJoinColumns = @JoinColumn(name = "recursos_id"))
	@Getter @Setter
	@JsonIgnore
	private List<PlanoAtivacao> planoAtivacaos;

}
