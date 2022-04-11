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
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.service.PlanoAtivacaoService;

@RestController
@RequestMapping("/planoAtivacao")
@CrossOrigin(origins = "http://localhost:3000")
public class PlanoAtivacaoController {

	@Autowired
	PlanoAtivacaoService planoAtivacaoService;
		
		@GetMapping("/buscarTodos")
		public List<PlanoAtivacao> buscarTodos() {
			try {
				return planoAtivacaoService.buscarPlanosContingencia();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@GetMapping("/buscarById")
		public Optional<PlanoAtivacao> buscarTodos(@RequestParam("idPlano") Integer idPlano) {
			try {
				return planoAtivacaoService.buscarPlanosContingenciaById(idPlano);
			} catch (Exception e) {
				throw e;
			}
		}
		
		@GetMapping("/buscarResumoPlano")
		public List<PlanoAtivacaoResumoDAO> buscarResumoTodos() {
			try {
				return planoAtivacaoService.buscarPlanosContingenciaResumo();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastrar")
		public PlanoAtivacao cadastrar(@RequestBody PlanoAtivacao p) {
			try {
				return planoAtivacaoService.cadastraPlanosContingencia(p);
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastroDefault")
		public PlanoAtivacao cadastrarDefault() {
			try {
				return planoAtivacaoService.cadastroDefaultPlanosContingencia();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PutMapping("/editar")
		public PlanoAtivacao editar(@RequestBody PlanoAtivacao p) {
			try {
				return planoAtivacaoService.editaPlanosContingencia(p);
			} catch (Exception e) {
				throw e;
			}
		}

	}

