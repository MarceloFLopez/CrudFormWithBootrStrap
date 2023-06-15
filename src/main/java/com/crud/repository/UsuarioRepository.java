package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
