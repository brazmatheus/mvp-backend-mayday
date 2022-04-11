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
import com.backend.mayday.model.Tags;
import com.backend.mayday.service.PlanoAtivacaoService;
import com.backend.mayday.service.TagsService;

@RestController
@RequestMapping("/tags")
@CrossOrigin(origins = "http://localhost:3000")
public class TagsController {

	@Autowired
	TagsService tagsService;
		
		
		@PostMapping("/cadastrar")
		public Tags cadastrar(@RequestBody Tags t) {
			try {
				return tagsService.cadastrarTags(t);
			} catch (Exception e) {
				throw e;
			}
		}

	}

