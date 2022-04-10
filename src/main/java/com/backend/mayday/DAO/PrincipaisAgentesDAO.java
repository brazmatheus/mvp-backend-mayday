package com.backend.mayday.DAO;

import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PrincipaisAgentesDAO {
	
	@Getter @Setter
	private Integer id;

	@Getter @Setter
	private String nome;

	@Getter @Setter
	private String cargo;

	@Getter @Setter
	private String telefone;
	
	public PrincipaisAgentesDAO convertPrincipaisAgentesDAO(Pessoa pAgentes) {
		
		this.id = pAgentes.getCpf();
		this.cargo = pAgentes.getCargo().getDescCargo();
		this.nome = pAgentes.getNome();
		this.telefone = pAgentes.getTelefone();
		
		return this;
	}

}
