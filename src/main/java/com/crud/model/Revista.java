package com.crud.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.EAN;
import org.hibernate.validator.constraints.ISBN;

public class Revista implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3, message = "O Titulo deve ter no minimo 3 caracteres!")
	private String titulo;
	@NotNull
	private Integer edicao;
	@Size(min = 6,message = "A Chamada Principal deve ter no minimo 6 caracteres!")
	private String chamadaPrincipal;
	@Size(min = 6,message = "A Descrição da Edição deve ter no minimo 6 caracteres!")
	private String descricacaoEdicao;
	@Size(min = 6,message = "A Palavra Chave deve ter no minimo 6 caracteres!")
	private String palavraChave;
	@Size(min = 6,message = "O Autor deve ter no minimo 6 caracteres!")
	private String autor;
	@NotNull	
	private Integer numeroPagina;
	@EAN
	@Size(min = 13, max=13, message = "O Código deBarras deve ter no minimo 13 caracteres!")
	private Long codigoBarras;
	@EAN(message = "O EAN deve ter no minimo 13 caracteres!")
	private Long codigoEan;
	@ISBN(message = "O ISBN deve ter no minimo 13 caracteres!")
	private Long isbn;
	@Size(min = 7, message = "O código BISAC deve ter no minimo 7 caracteres!")
	private String bisac;
	@Size(min = 7, message = "A Descrição BISAC deve ter no minimo 7 caracteres!")
	private String descricacaoBisac;
	@NotNull
	@Size(min = 3, message = "A Categoria deve ter no minimo 3 caracteres!")
	private String categoria;
	@NotNull
	@Size(min = 3, message = "A Sub-Categoria deve ter no minimo 3 caracteres!")
	private String subCategoria;
	@NotNull
	@Size(min = 3, message = "A Editora deve ter no minimo 3 caracteres!")
	private String editora;

	@NotNull
	@Size(min = 3, message = "A Periodicidade deve ter no minimo 3 caracteres!")
	private String periodicidade;
}
