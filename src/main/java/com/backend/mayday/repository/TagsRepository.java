package com.backend.mayday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.mayday.model.PlanoContingencia;

@Repository
public interface TagsRepository extends JpaRepository<PlanoContingencia, Integer> {
	
}
