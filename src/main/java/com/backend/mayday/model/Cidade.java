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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CIDADE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cidade {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Getter @Setter
	@Column(name="ID")
	private Integer id;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Getter @Setter
	@Column(name="IBGE")
	private String ibge;
	
	@Getter @Setter
	@OneToMany(targetEntity = PlanoAtivacao.class , mappedBy = "cidade")
	@JsonIgnore
	private List<PlanoAtivacao> planoAtivacao;
	
	@Getter @Setter
	@OneToMany(targetEntity = PlanoAtivacao.class , mappedBy = "cidade")
	@JsonIgnore
	private List<Pessoa> pessoa;
	
}
