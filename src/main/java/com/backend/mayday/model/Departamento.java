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
	private Integer idDepartamento;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descDepartamento;

	@OneToMany(targetEntity = Cargo.class , mappedBy = "departamento")	
	@Getter @Setter
	@JsonIgnore
	private List<Cargo> cargo;
	
//	public Departamento withLinkedCargo() {
//		for (var c : this.cargo) {
//			c.setDepartamento(this);
//		}
//		return this;
//	}
	
}
