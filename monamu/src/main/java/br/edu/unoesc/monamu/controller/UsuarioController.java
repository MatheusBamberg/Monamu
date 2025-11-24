package br.edu.unoesc.monamu.controller;

import org.springframework.http.ResponseEntity;
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
	public Usuario criar(@RequestParam String username, @RequestParam String senha) {
		return service.criarUsuario(username, senha);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam String username, @RequestParam String senha) {
		try {
			service.login(username, senha);
			return ResponseEntity.ok("OK");
		} catch (RuntimeException e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

}
