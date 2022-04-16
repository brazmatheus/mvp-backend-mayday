package com.backend.mayday.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.mayday.DAO.PlanoAtivacaoResumoDAO;
import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.Pessoa;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.service.CidadeService;
import com.backend.mayday.service.PessoaService;
import com.backend.mayday.service.PlanoAtivacaoService;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "http://localhost:3000")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
		
		@GetMapping("/buscarByCpf")
		public Optional<Pessoa> buscarPessoaByCpf(@RequestParam String cpf) {
			try {
				return pessoaService.buscarPessoaByCpf(cpf);
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastrar")
		public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
			try {
				return pessoaService.cadastrarPessoa(pessoa);
			}catch(Exception e) {
				throw e;
			}
		}

	}

