package com.backend.mayday.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.Tags;
import com.backend.mayday.repository.PessoaRepository;
import com.backend.mayday.repository.PlanoAtivacaoRepository;
import com.backend.mayday.repository.TagsRepository;
import com.backend.mayday.util.Converters;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;

	public Optional<Pessoa> buscarPessoaByCpf(String cpf) {
		try {
			return this.pessoaRepository.findById(cpf);
		} catch (Exception e) {
			throw e;
		}
	}

	public Pessoa cadastrarPessoa(Pessoa pessoa) {
		try {
			return this.pessoaRepository.save(pessoa);
		} catch (Exception e) {
			throw e;
		}
	}

}
