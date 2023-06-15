package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;
import com.crud.service.impl.UsuarioServiceImpl;

@Service
public class UsuarioService implements UsuarioServiceImpl{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public List<Usuario> listarTodos() {
		return repository.findAll();
	}

	@Override
	public Optional<Usuario> buscarId(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deletarUsuario(Usuario usuario) {
		repository.delete(usuario);
	}

}
