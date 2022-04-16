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
import com.backend.mayday.model.Cargo;
import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.service.CargoService;
import com.backend.mayday.service.CidadeService;
import com.backend.mayday.service.PlanoAtivacaoService;

@RestController
@RequestMapping("/cargo")
@CrossOrigin(origins = "http://localhost:3000")
public class CargoController {

	@Autowired
	CargoService cargoService;
		
		@GetMapping("/buscarById")
		public List<Cargo> buscarById(@RequestParam Integer idDepartamento) {
			try {
				return cargoService.buscarByDepartamentoId(idDepartamento);
			} catch (Exception e) {
				throw e;
			}
		}

	}

