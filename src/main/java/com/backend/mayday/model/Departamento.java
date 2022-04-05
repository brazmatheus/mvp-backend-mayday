package com.backend.mayday.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento {

	@Id
	@Getter @Setter
	@Column(name="ID")
	private Integer idCargo;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descCargo;
	
	@Getter @Setter
	@OneToMany(targetEntity = Cargo.class , mappedBy = "departamento")
	private List<Cargo> cargo;
	
}
