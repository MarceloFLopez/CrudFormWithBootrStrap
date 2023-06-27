package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public List<Usuario> listarTodos(String palavrachave) {
		if(palavrachave != null) {
			return repository.findAll(palavrachave);
		}
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

	@Override
	public Usuario findByLogin(String login) {
		return repository.findByLogin(login);
	}

	@Override
	public Usuario findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	@Override
	public Usuario findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public Page<Usuario> findPaginated(int pageNo, int pageSize,String sortfield, String sortDiretcion) {
		Sort sort = sortDiretcion.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortfield).ascending():
			Sort.by(sortfield).descending();
		Pageable pageable = PageRequest.of(pageNo -1, pageSize, sort);
		return this.repository.findAll(pageable);
	}

}
