package com.backend.mayday.model;

import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DEPARTAMENTO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Departamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Getter @Setter
	@Column(name="ID")
	private Integer id;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descricao;

	@OneToMany(targetEntity = Cargo.class , mappedBy = "departamento")	
	@Getter @Setter
	@JsonIgnore
	private List<Cargo> cargo;

	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_CIDADE")
	private Cidade cidade;
	
}
