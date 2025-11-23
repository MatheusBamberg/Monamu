package br.edu.unoesc.monamu.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.monamu.model.Usuario;
import br.edu.unoesc.monamu.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class UsuarioController {


	private final UsuarioService service;
	
	
	public UsuarioController(UsuarioService service) {
	this.service = service;
	}
	
	
	@PostMapping("/criar")
	public Usuario criar(@RequestParam Integer codfun,
	@RequestParam String username,
	@RequestParam String senha) {
	return service.criarUsuario(codfun, username, senha);
	}
	
	
	@PostMapping("/login")
	public String login(@RequestParam String username,
	@RequestParam String senha) {
	service.login(username, senha);
	return "Login realizado com sucesso";
	}
}
