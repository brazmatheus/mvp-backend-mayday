package com.backend.mayday.util;

import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.DAO.PrincipaisAgentesDAO;
import com.backend.mayday.DAO.TagsPlanoAtivacaoResumoDAO;
import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Tags;

public class Converters {
	
	public PlanoAtivacaoResumoDAO planoAtivacaoConv(PlanoAtivacao planoAtivacao) {
		PlanoAtivacaoResumoDAO planoAtivacaoResumoDAO = new PlanoAtivacaoResumoDAO();
		planoAtivacaoResumoDAO.setId(planoAtivacao.getId());
		for(Pessoa pessoa: planoAtivacao.getAgentes()) {
			planoAtivacaoResumoDAO.getPrincipaisAgentes().add(this.principaisAgentesConv(pessoa));
		}
		for(Tags tags: planoAtivacao.getTags()) {
			planoAtivacaoResumoDAO.getTags().add(this.tagsPlanoAtivacaoResumoConv(tags));
		}
		planoAtivacaoResumoDAO.setTitulo(planoAtivacao.getTitulo());
		planoAtivacaoResumoDAO.setSubTitulo(planoAtivacao.getSubtitulo());
		return planoAtivacaoResumoDAO;
	}
	
	public PrincipaisAgentesDAO principaisAgentesConv(Pessoa agente) {
		PrincipaisAgentesDAO principaisAgentesDAO = new PrincipaisAgentesDAO();
		principaisAgentesDAO.setCargo(agente.getCargo().getDescCargo());
		principaisAgentesDAO.setId(agente.getCpf());
		principaisAgentesDAO.setNome(agente.getNome());
		principaisAgentesDAO.setTelefone(agente.getTelefone());
		return principaisAgentesDAO;
	}
	
	public TagsPlanoAtivacaoResumoDAO tagsPlanoAtivacaoResumoConv(Tags tags) {
		TagsPlanoAtivacaoResumoDAO tagsPlanoAtivacaoResumoDAO = new TagsPlanoAtivacaoResumoDAO();
		tagsPlanoAtivacaoResumoDAO.setCor(tags.getCor());
		tagsPlanoAtivacaoResumoDAO.setId(tags.getIdTags());
		tagsPlanoAtivacaoResumoDAO.setTitulo(tags.getDescTags());
		return tagsPlanoAtivacaoResumoDAO;
	}

}
