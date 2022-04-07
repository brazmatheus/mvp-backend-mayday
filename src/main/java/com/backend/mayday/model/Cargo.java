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
@Table(name="CARGO")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="ID")
	private Integer idCargo;
	

	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descCargo;
	
	@Getter @Setter
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_DEPARTAMENTO")
	private Departamento departamento;
	
	@Getter @Setter
	@OneToMany(targetEntity = Pessoa.class , mappedBy = "cargo")
	@JsonIgnore
	private List<Pessoa> pessoa;
	
//	public Cargo withLinkedPessoa() {
//		for (var p : this.pessoa) {
//			p.setCargo(this);
//		}
//		return this;
//	}
	

}
