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
import com.backend.mayday.model.PontosInteresse;
import com.backend.mayday.model.TiposPontoInteresse;
import com.backend.mayday.service.CidadeService;
import com.backend.mayday.service.PlanoAtivacaoService;
import com.backend.mayday.service.PontoInteresseService;
import com.backend.mayday.service.TipoPontoInteresseService;

@RestController
@RequestMapping("/pontoInteresse")
@CrossOrigin(origins = "http://localhost:3000")
public class PontoInteresseController {

	@Autowired
	PontoInteresseService pontoInteresseService;
		
		@GetMapping("/buscarByIdPlano")
		public List<PontosInteresse> buscarTodos(@RequestParam Integer idPlano) {
			try {
				return pontoInteresseService.buscarPontoInteresse(idPlano);
			} catch (Exception e) {
				throw e;
			}
		}

	}

