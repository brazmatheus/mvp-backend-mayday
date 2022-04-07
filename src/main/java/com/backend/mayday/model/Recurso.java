package com.backend.mayday.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="RECURSO")
public class Recurso {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter @Setter
	@Column(name="ID")
	private String idRecurso;
	
	@Getter @Setter
	@Column(name="DESCRICAO")
	private String descRecurso;
	
	@OneToOne
	@Getter @Setter
    @JoinColumn(name = "ID_RESPONSAVEL", referencedColumnName = "ID")
	private Responsavel responsavel;
	
	@Getter @Setter
	@Column(name="QUANTIDADE")
	private String quantidadeRecurso;
	
//	@Getter @Setter
//	@OneToMany(mappedBy = "recurso")
//	private List<PlanoContingenciaRecurso> planosContingencia;

}
