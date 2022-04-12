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
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.service.CidadeService;
import com.backend.mayday.service.PlanoAtivacaoService;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = "http://localhost:3000")
public class CidadeController {

	@Autowired
	CidadeService cidadeService;
		
		@GetMapping("/buscarTodos")
		public List<Cidade> buscarTodos() {
			try {
				return cidadeService.buscarCidade();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastrar")
		public List<Cidade> cadastrar(@RequestBody List<Cidade> c) {
			try {
				return cidadeService.cadastrarCidade(c);
			} catch (Exception e) {
				throw e;
			}
		}
		
//		@PutMapping("/editar")
//		public PlanoAtivacao editar(@RequestBody PlanoAtivacao p) {
//			try {
//				return planoAtivacaoService.editaPlanosContingencia(p);
//			} catch (Exception e) {
//				throw e;
//			}
//		}

	}

