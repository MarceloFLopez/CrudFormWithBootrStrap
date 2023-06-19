package com.crud.service.impl;

import java.util.List;
import java.util.Optional;

import com.crud.model.Produto;

public interface  ProdutoServiceImpl {

	Produto salvarProduto(Produto produto);

	List<Produto> listarTodos(String palavraChave);

	Optional<Produto> buscarId(Long id);

	void deletarProduto(Produto produto);
}
