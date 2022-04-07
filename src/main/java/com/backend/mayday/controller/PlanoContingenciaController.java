package com.backend.mayday.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.mayday.model.PlanoContingencia;
import com.backend.mayday.service.PlanoContingenciaService;

@RestController
@RequestMapping("/planosContingencia")
public class PlanoContingenciaController {

	@Autowired
	PlanoContingenciaService planoContingenciaService;
		
		@GetMapping("/buscarTodos")
		public List<PlanoContingencia> buscar() {
			try {
				return planoContingenciaService.buscarPlanosContingencia();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastrar")
		public PlanoContingencia cadastrar(@RequestBody PlanoContingencia p) {
			try {
				return planoContingenciaService.cadastraPlanosContingencia(p);
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PostMapping("/cadastroDefault")
		public PlanoContingencia cadastrarDefault() {
			try {
				return planoContingenciaService.cadastroDefaultPlanosContingencia();
			} catch (Exception e) {
				throw e;
			}
		}
		
		@PutMapping("/editar")
		public PlanoContingencia editar(@RequestBody PlanoContingencia p) {
			try {
				return planoContingenciaService.editaPlanosContingencia(p);
			} catch (Exception e) {
				throw e;
			}
		}

	}

