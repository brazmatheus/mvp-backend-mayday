package com.backend.mayday.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Recurso;
import com.backend.mayday.repository.AgenteRepository;
import com.backend.mayday.repository.CidadeRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.util.Converters;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> buscarCidade() {
		try {
			return this.cidadeRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<Cidade> cadastrarCidade(List<Cidade> cidade) {
		try {
			return this.cidadeRepository.saveAll(cidade);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
