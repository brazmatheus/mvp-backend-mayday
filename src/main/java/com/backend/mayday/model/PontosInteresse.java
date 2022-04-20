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
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "PONTOINTERESSE")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class PontosInteresse {
	
	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@NotNull
	@Column(name="MENSAGEM")
	private String mensagem;
	
	@Getter @Setter
	@NotNull
	@Column(name="COR")
	private String cor;

	@Getter @Setter
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TIPOSPONTO", referencedColumnName = "ID")
	private TiposPontoInteresse tipoPontoInteresse;
		
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="ID_PLANO", referencedColumnName = "ID")
	@JsonIgnore
	private PlanoAtivacao planoAtivacao;

}
