package com.backend.mayday.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="ID")
	private Integer idDepartamento;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descDepartamento;
	
	@Getter @Setter
	@OneToMany(targetEntity = Cargo.class , mappedBy = "departamento")
	private List<Cargo> cargo;
	
}
