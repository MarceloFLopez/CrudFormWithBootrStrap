package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crud.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Query("SELECT u FROM Usuario u WHERE "
			+ "	   u.nome LIKE %?1%"
			+ " OR u.cpf LIKE %?1% "
			+ " OR u.email LIKE %?1% ORDER BY u.id")
	public List<Usuario> findAll(String palavraChave);
	
	@Query("SELECT u FROM Usuario u ORDER BY u.id")
	public List<Usuario> findAll();
	
	Usuario findByLogin(String login);
	
	Usuario findByCpf(String cpf);
	
	Usuario findByEmail(String email);
	
}
