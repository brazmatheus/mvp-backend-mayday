package com.backend.mayday.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Tags;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.repository.TagsRepository;
import com.backend.mayday.util.Converters;

@Service
public class TagsService {
	
	@Autowired
	private TagsRepository tagsRepository;
	
//	public List<PlanoAtivacao> buscarPlanosContingencia() {
//		try {
//			return this.tagsRepository.findAll();
//		}catch(Exception e) {
//			throw e;
//		}
//	}
//	
//	public Optional<PlanoAtivacao> buscarPlanosContingenciaById(Integer idPlano) {
//		try {
//			return this.tagsRepository.findById(idPlano);
//		}catch(Exception e) {
//			throw e;
//		}
//	}

	public Tags cadastrarTags(Tags tags) {
		try {
			return this.tagsRepository.save(tags);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
