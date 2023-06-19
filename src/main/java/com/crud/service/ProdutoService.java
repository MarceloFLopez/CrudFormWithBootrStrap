package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Produto;
import com.crud.repository.ProdutoRepository;
import com.crud.service.impl.ProdutoServiceImpl;

@Service
public class ProdutoService implements ProdutoServiceImpl{
	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public Produto salvarProduto(Produto produto) {
		return repository.save(produto);
	}
	
	@Override
	public List<Produto> listarTodos(String palavrachave) {
		if(palavrachave != null) {
			return repository.findAll(palavrachave);
		}
		return repository.findAll();
	}

	@Override
	public Optional<Produto> buscarId(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deletarProduto(Produto produto) {
		repository.delete(produto);
	}

}
