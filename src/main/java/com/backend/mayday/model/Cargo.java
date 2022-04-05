package com.backend.mayday.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="CARGO")
public class Cargo {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private Integer idCargo;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descCargo;

}
