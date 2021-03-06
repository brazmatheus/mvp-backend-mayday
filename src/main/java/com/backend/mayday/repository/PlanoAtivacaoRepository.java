package com.backend.mayday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.mayday.model.PlanoAtivacao;

@Repository
public interface PlanoAtivacaoRepository extends JpaRepository<PlanoAtivacao, Integer> {
	
	List<PlanoAtivacao> findByCidadeId(Integer idCidade);
	
}
