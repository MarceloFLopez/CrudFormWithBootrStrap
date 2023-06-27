package com.crud.service.impl;

import java.util.Optional;

import com.crud.model.Papel;

public interface PapelServiceImpl {

	Papel findByPapel(String papel);

	Papel salvarPapel(Papel papel);

	Optional<Papel> buscarId(Long id);

}
