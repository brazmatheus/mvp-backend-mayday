package com.backend.mayday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.TiposPontoInteresse;

@Repository
public interface TipoPontoInteresseRepository extends JpaRepository<TiposPontoInteresse, Integer> {
	
}
