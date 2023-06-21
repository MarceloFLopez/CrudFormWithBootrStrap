package com.crud.service.impl;

import java.util.List;
import java.util.Optional;

import com.crud.model.Usuario;

public interface UsuarioServiceImpl {

	Usuario salvarUsuario(Usuario usuario);

	List<Usuario> listarTodos(String palavraChave);

	Optional<Usuario> buscarId(Long id);

	void deletarUsuario(Usuario usuario);

}
