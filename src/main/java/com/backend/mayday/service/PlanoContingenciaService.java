package com.backend.mayday.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.model.PlanoContingencia;
import com.backend.mayday.repository.PlanoContingenciaRepository;

@Service
public class PlanoContingenciaService {
	
	@Autowired
	private PlanoContingenciaRepository planoContingenciaRepository;
	
	public List<PlanoContingencia> buscarPlanosContingencia() {
		try {
			return this.planoContingenciaRepository.findAll();
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoContingencia cadastraPlanosContingencia(PlanoContingencia p) {
		try {
			PlanoContingencia plano = p.withLinkedTags();
			return this.planoContingenciaRepository.save(plano);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoContingencia cadastroDefaultPlanosContingencia() {
		try {
			PlanoContingencia p = new PlanoContingencia();
			return this.planoContingenciaRepository.save(p);
		}catch(Exception e) {
			throw e;
		}
	}
	
	public PlanoContingencia editaPlanosContingencia(PlanoContingencia p) {
		try {
			return this.planoContingenciaRepository.save(p);
		}catch(Exception e) {
			throw e;
		}
	}
	
}
