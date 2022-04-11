package com.backend.mayday.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.util.Converters;

@Service
public class PlanoAtivacaoService {
	
	@Autowired
	private PlanoAtivacaoRepository planoAtivacaoRepository;
	
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
	
	public PlanoAtivacao cadastraPlanosContingencia(PlanoAtivacao p) {
		try {
			PlanoAtivacao plano = p.withLinkedTags();
			return this.planoAtivacaoRepository.save(plano);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoAtivacao cadastroDefaultPlanosContingencia() {
		try {
			PlanoAtivacao p = new PlanoAtivacao();
			return this.planoAtivacaoRepository.save(p.planoAtivacaoDefault());
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
