package com.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Produto;
import com.crud.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public String index(Model model,String palavraChave) {
		List<Produto> listaProdutos = produtoService.listarTodos(palavraChave);
		model.addAttribute("listaProdutos", listaProdutos);
		return "/auth/produto/public-index-produto";
	}
	
	@GetMapping("/novo")
	public String novoProduto(Model model) {
		model.addAttribute("produto", new Produto());
		return "/auth/produto/public-cria-produto";
	}
	
	@PostMapping("/guardar")
	public String novoProduto(@ModelAttribute("produto") Produto produto) {
		produtoService.salvarProduto(produto);
		return "redirect:/produto";
	}
	
	@GetMapping("/apagar/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Produto produto = produtoService.buscarId(id).orElseThrow(() -> new IllegalArgumentException("Id Inválido:" + id));
		produtoService.deletarProduto(produto);
		return "redirect:/produto";
	}


	@GetMapping("/editar/{id}")
	public String editarProduto(@PathVariable("id") long id, Model model) {
		Optional<Produto> produtoVelho = produtoService.buscarId(id);
		if (!produtoVelho.isPresent()) {
            throw new IllegalArgumentException("Usuário inválido:" + id);
        } 
		Produto produto = produtoVelho.get();
	    model.addAttribute("produto", produto);
	    return "/auth/produto/public-edita-produto";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProduto(@PathVariable("id") long id, 
			@Valid Produto produto, BindingResult result) {
		if (result.hasErrors()) {
	    	produto.setId(id);
	        return "/auth/produto/public-edita-produto";
	    }
		produtoService.salvarProduto(produto);
	    return "redirect:/produto";
	}


}
