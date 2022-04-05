package com.backend.mayday.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class SMSResponse {

	@Getter @Setter
	private String situacao;

	@Getter @Setter
	private String codigo;

	@Getter@Setter
	private String id;

	@Getter @Setter
	private String number;

	@Getter @Setter
	private String descricao;
	
}

