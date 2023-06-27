package com.crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.crud.model.Papel;
import com.crud.model.Usuario;
import com.crud.service.PapelService;
import com.crud.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private PapelService papelService;

	@GetMapping("/novo")
	public String usuarioNovo(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "/publica-criar-usuario";
	}

	@PostMapping("/salvar")
	public String salvarUsuario(@Valid Usuario usuario, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/publica-criar-usuario";
		}

		// Validação dos campos Login/CPF/Email
		Usuario usrLogin = service.findByLogin(usuario.getLogin());
		Usuario usrCpf = service.findByCpf(usuario.getCpf());
		Usuario usrEmail = service.findByEmail(usuario.getEmail());
		if (usrLogin != null || usrCpf != null || usrEmail != null) {
			if (usrLogin != null)
				model.addAttribute("loginExiste", "Login já cadastrado!");
			if (usrCpf != null)
				model.addAttribute("cpfExiste", "CPF já cadastrado!");
			if (usrEmail != null)
				model.addAttribute("emailExiste", "EMAIL já cadastrado!");
			return "/publica-criar-usuario";
		}

		// Busca o papel básico de usuário
		Papel papel = papelService.findByPapel("USER");
		List<Papel> papeis = new ArrayList<>();
		papeis.add(papel);//
		usuario.setPapeis(papeis);

		// Salvar registro
		service.salvarUsuario(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return "redirect:/usuario/novo";
	}

	@GetMapping("/admin/listar")
	public String listarUsuarios(Model model, String palavraChave) {
		List<Usuario> usuarios = service.listarTodos(palavraChave);
		model.addAttribute("usuarios", usuarios);
		return "/auth/admin/admin-listar-usuario";
	}

	@GetMapping("/admin/apagar/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Usuario usuario = service.buscarId(id).orElseThrow(() -> new IllegalArgumentException("Id Inválido:" + id));
		service.deletarUsuario(usuario);
		return "redirect:/usuario/admin/listar";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioVelho = service.buscarId(id);
		if (!usuarioVelho.isPresent()) {
			throw new IllegalArgumentException("Usuário inválido:" + id);
		}
		Usuario usuario = usuarioVelho.get();
		model.addAttribute("usuario", usuario);
		return "/auth/user/user-alterar-usuario";
	}

	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, @Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			usuario.setId(id);
			return "/auth/user/user-alterar-usuario";
		}
		service.salvarUsuario(usuario);
		return "redirect:/usuario/admin/listar";
	}

	@GetMapping("editarPapel/{id}")
	public String editarPapelUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioVelho = service.buscarId(id);
		if (!usuarioVelho.isPresent()) {
			throw new IllegalArgumentException("Usuário inválido:" + id);
		}
		Usuario usuario = usuarioVelho.get();
		model.addAttribute("usuario", usuario);
		return "/auth/admin/user-alterar-papel";
	}

	

}
