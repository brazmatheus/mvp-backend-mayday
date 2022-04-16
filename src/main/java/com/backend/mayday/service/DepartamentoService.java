package com.backend.mayday.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.Cargo;
import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.Departamento;
import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Recurso;
import com.backend.mayday.repository.PessoaRepository;
import com.backend.mayday.repository.CargoRepository;
import com.backend.mayday.repository.CidadeRepository;
import com.backend.mayday.repository.DepartamentoRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.util.Converters;

@Service
public class DepartamentoService {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public Optional<Departamento> buscarById(Integer idDepartamento) {
		return this.departamentoRepository.findById(idDepartamento);
	}

	public List<Departamento> buscarByCidadeId(Integer idDepartamento) {
		return this.departamentoRepository.findByCidadeId(idDepartamento);
	}
	
	public List<Departamento> buscarTodos() {
		return this.departamentoRepository.findAll();
	}
	
}
