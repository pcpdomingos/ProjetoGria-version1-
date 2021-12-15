package org.gria.projetoGria.repository;

import java.util.List;

import org.gria.projetoGria.model.Cargo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	public List<Cargo> findAllByNomeContainingIgnoreCase(String nome); 

	}


