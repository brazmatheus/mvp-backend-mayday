package com.backend.mayday.DAO;

import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PrincipaisAgentesDAO {
	
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String nome;

	@Getter @Setter
	private String cargo;

	@Getter @Setter
	private String telefone;

}
