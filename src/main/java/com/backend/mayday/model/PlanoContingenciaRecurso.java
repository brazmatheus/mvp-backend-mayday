package com.backend.mayday.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "PLANOCONTINGENCIA_RECURSO")
@IdClass(PlanoContingenciaRecursoKey.class)
public class PlanoContingenciaRecurso {

	@Id
	@ManyToOne
	@MapsId("planoContingencia")
	@JoinColumn(name = "PLANOCONTINGENCIA_ID")
	PlanoContingencia planoContingencia;
 
	@Id
	@ManyToOne
	@MapsId("recurso")
	@JoinColumn(name = "RECURSO_ID")
	Recurso recurso;

}
