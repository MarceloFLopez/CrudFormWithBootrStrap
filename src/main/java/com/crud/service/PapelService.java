package com.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Papel;
import com.crud.repository.PapelRepository;
import com.crud.service.impl.PapelServiceImpl;

@Service
public class PapelService implements PapelServiceImpl{

	@Autowired
	private PapelRepository repository;

	@Override
	public Papel findByPapel(String papel) {
		return repository.findByPapel(papel);
	}

	@Override
	public Papel salvarPapel(Papel papel) {
		return repository.save(papel);
	}

	@Override
	public Optional<Papel> buscarId(Long id) {
		return repository.findById(id);
	}


}
