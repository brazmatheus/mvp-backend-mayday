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
import com.backend.mayday.model.TiposPontoInteresse;
import com.backend.mayday.repository.PessoaRepository;
import com.backend.mayday.repository.CidadeRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.repository.TipoPontoInteresseRepository;
import com.backend.mayday.util.Converters;

@Service
public class TipoPontoInteresseService {
	
	@Autowired
	private TipoPontoInteresseRepository tipoPontoInteresseRepository;
	
	public List<TiposPontoInteresse> buscarPontoInteresse() {
		try {
			return this.tipoPontoInteresseRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}
	
}
