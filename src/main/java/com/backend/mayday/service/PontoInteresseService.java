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
import com.backend.mayday.model.PontosInteresse;
import com.backend.mayday.model.Recurso;
import com.backend.mayday.model.TiposPontoInteresse;
import com.backend.mayday.repository.PessoaRepository;
import com.backend.mayday.repository.CidadeRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.repository.PontoInteresseRepository;
import com.backend.mayday.repository.TipoPontoInteresseRepository;
import com.backend.mayday.util.Converters;

@Service
public class PontoInteresseService {
	
	@Autowired
	private PontoInteresseRepository pontoInteresseRepository;
	
	public List<PontosInteresse> buscarPontoInteresse(Integer idPlanoAtivacao) {
		try {
			return this.pontoInteresseRepository.findByPlanoAtivacaoId(idPlanoAtivacao);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
