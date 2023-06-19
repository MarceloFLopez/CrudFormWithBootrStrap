package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("SELECT p FROM Produto p WHERE "
			+ "	   p.nome LIKE %?1%"
			+ " OR p.categoria LIKE %?1% "
			+ " OR p.marca LIKE %?1% ")
	public List<Produto> findAll(String palavraChave);
}
