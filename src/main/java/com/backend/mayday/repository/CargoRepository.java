package com.backend.mayday.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.mayday.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
	
	public List<Cargo> findByDepartamentoId(Integer idCargo);
	
}
