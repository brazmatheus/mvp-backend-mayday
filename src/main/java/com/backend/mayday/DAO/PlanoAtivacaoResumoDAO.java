package com.backend.mayday.DAO;

import java.util.ArrayList;
import java.util.List;

import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Tags;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class PlanoAtivacaoResumoDAO {
	
	@Getter @Setter
	private Integer id;

	@Getter @Setter
	private String titulo;

	@Getter @Setter
	private String subTitulo;
	
	@Getter @Setter
	private List<PrincipaisAgentesDAO> principaisAgentes = new ArrayList<PrincipaisAgentesDAO>();

	@Getter @Setter
	private List<TagsPlanoAtivacaoResumoDAO> tags = new ArrayList<TagsPlanoAtivacaoResumoDAO>();

}
