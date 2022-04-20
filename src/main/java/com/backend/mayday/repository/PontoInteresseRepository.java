package com.backend.mayday.repository;

import java.util.List;

import javax.persistence.NamedNativeQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.mayday.model.Cidade;
import com.backend.mayday.model.PlanoAtivacao;
import com.backend.mayday.model.PontosInteresse;
import com.backend.mayday.model.TiposPontoInteresse;

@Repository
public interface PontoInteresseRepository extends JpaRepository<PontosInteresse, Integer> {
	
	public List<PontosInteresse> findByPlanoAtivacaoId(Integer idPlanoAtivacao);
	
//	@NamedNativeQuery("UPDATE pontointeresse SET id_plano = " + idPlanoAtivacao)
//	public void updatePlanoAtivacaoId(Integer idPlanoAtivacao, Integer idPontoInteresse);
	
}
