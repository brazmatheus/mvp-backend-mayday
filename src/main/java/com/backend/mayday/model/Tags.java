package com.backend.mayday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TAGS")
public class Tags {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private String idTags;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descTags;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="ID_PLANOCONTINGENCIA")
	private PlanoContingencia planoContingencia;

}
