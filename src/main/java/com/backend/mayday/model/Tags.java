package com.backend.mayday.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TAGS")
@JsonIgnoreProperties(value = {"planoAtivacao"})
public class Tags {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Getter @Setter
	@Column(name="ID")
	private Integer idTags;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descTags;
	
	@Getter @Setter
	@Column(name="COR")
	private String cor;
	
	@Getter @Setter
	@ManyToOne()
	@JoinColumn(name="ID_PLANOCONTINGENCIA")
	private PlanoAtivacao planoAtivacao;

}
