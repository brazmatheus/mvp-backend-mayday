package com.backend.mayday.DAO;

import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Tags;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class TagsPlanoAtivacaoResumoDAO {
	
	@Getter @Setter
	private Integer id;

	@Getter @Setter
	private String titulo;

	@Getter @Setter
	private String cor;
	
	public TagsPlanoAtivacaoResumoDAO convertTagsPlanoAtivacaoDAO(Tags tags) {
		
		this.id = tags.getIdTags();
		this.cor = tags.getCor();
		this.titulo = tags.getDescTags();
		
		return this;
		
	}

}
