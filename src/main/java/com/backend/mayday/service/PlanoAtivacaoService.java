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
import com.backend.mayday.repository.PessoaRepository;
import com.backend.mayday.repository.CidadeRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.repository.PontoInteresseRepository;
import com.backend.mayday.util.Converters;

@Service
public class PlanoAtivacaoService {
	
	@Autowired
	private PlanoAtivacaoRepository planoAtivacaoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PontoInteresseRepository pontoInteresseRepository;
	
	public List<PlanoAtivacao> buscarPlanosContingencia() {
		try {
			return this.planoAtivacaoRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public Optional<PlanoAtivacao> buscarPlanosContingenciaById(Integer idPlano) {
		try {
			return this.planoAtivacaoRepository.findById(idPlano);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<PlanoAtivacaoResumoDAO> buscarPlanosContingenciaByIdCidade(Integer idCidade) {
		try {
			Converters converters = new Converters();
			List<PlanoAtivacao> pAtivacao = this.planoAtivacaoRepository.findByCidadeId(idCidade);
			List<PlanoAtivacaoResumoDAO> pResumo = new ArrayList<PlanoAtivacaoResumoDAO>();
			for(PlanoAtivacao p : pAtivacao) {
				pResumo.add(converters.planoAtivacaoConv(p));
			}
			return pResumo;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public List<PlanoAtivacaoResumoDAO> buscarPlanosContingenciaResumo() {
		try {
			Converters converters = new Converters();
			List<PlanoAtivacao> pAtivacao = this.planoAtivacaoRepository.findAll();
			List<PlanoAtivacaoResumoDAO> pResumo = new ArrayList<PlanoAtivacaoResumoDAO>();
			for(PlanoAtivacao p : pAtivacao) {
				pResumo.add(converters.planoAtivacaoConv(p));
			}
			return pResumo;
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoAtivacao cadastraPlanosContingencia(PlanoAtivacao plano) {
		try {
			List<Pessoa> agente = plano.getAgentes();
			List<Recurso> recursos = plano.getRecursos();
			Cidade cidade = plano.getCidade();
//			List<PontosInteresse> pontos = plano.getPontoInteresse();
			plano.setAgentes(null);
			plano.setRecursos(null);
			plano.setCidade(null);
//			plano.setPontoInteresse(null);
			for(PontosInteresse p: plano.getPontoInteresse()) {
				p.setPlanoAtivacao(plano);
			}
			PlanoAtivacao pSaved = this.planoAtivacaoRepository.save(plano);
			pSaved.setAgentes(agente);
			pSaved.setRecursos(recursos);
			pSaved.setCidade(cidade);
			return this.planoAtivacaoRepository.save(pSaved);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoAtivacao cadastroDefaultPlanosContingencia(Integer idCidade) {
		try {
			PlanoAtivacao p = new PlanoAtivacao();
			PlanoAtivacao pSaved = this.planoAtivacaoRepository.save(p.planoAtivacaoDefault());
			pSaved.setCidade(this.cidadeRepository.getById(idCidade));
			return this.planoAtivacaoRepository.save(pSaved);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoAtivacao editaPlanosContingencia(PlanoAtivacao p) {
		try {
			return this.planoAtivacaoRepository.save(p);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
