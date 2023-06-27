package com.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.crud.model.Usuario;

public interface UsuarioServiceImpl {

	Usuario salvarUsuario(Usuario usuario);

	List<Usuario> listarTodos(String palavraChave);

	Optional<Usuario> buscarId(Long id);

	void deletarUsuario(Usuario usuario);

	Usuario findByLogin(String login);

	Usuario findByCpf(String cpf);

	Usuario findByEmail(String email);
	
	Page<Usuario> findPaginated(int pageNo, int pageSize, String sortfield, String sortDiretcion);
}
