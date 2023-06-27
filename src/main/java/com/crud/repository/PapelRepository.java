package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Papel;

public interface PapelRepository extends JpaRepository<Papel, Long> {

	Papel findByPapel(String papel);
	
}
