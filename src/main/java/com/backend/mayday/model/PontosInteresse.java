package com.backend.mayday.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PONTOINTERESSE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PontosInteresse {
	
	@Id
	@Getter @Setter
	@Column(name="ID")
	private Integer id;

	@Getter @Setter
	@NotNull
	@Column(name="LATITUDE")
	private String latitude;
	
	@Getter @Setter
	@NotNull
	@Column(name="LONGITUTE")
	private String longitude;

	@Getter @Setter
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPOSPONTO", referencedColumnName = "ID")
	private TiposPontoInteresse tipoPontoInteresse;
		
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ID_PLANO")
	private PlanoAtivacao planoAtivacao;

}
