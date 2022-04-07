package com.backend.mayday.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PLANOCONTINGENCIA_AGENTE")
@IdClass(PlanoContingenciaAgenteKey.class)
@JsonIgnoreProperties(value = {"planoContingencia"})
public class PlanoContingenciaAgente {

	@Id
	@ManyToOne
	@Getter @Setter
	@MapsId("planoContingencia")
	@JoinColumn(name = "PLANOCONTINGENCIA_ID")
	PlanoContingencia planoContingencia;
 
	@Id
	@ManyToOne
	@Getter @Setter
	@MapsId("agente")
	@JoinColumn(name = "AGENTE_ID")
	Pessoa agente;

}

