package com.backend.mayday.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PlanoContingenciaRecursoKey implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8155193613418415777L;

	PlanoContingencia planoContingencia;

	Recurso recurso;

}
