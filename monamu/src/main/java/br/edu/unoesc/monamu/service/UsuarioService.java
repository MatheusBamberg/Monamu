package br.edu.unoesc.monamu.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Usuario;
import br.edu.unoesc.monamu.repository.FuncionarioRepository;
import br.edu.unoesc.monamu.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;
	private final BCryptPasswordEncoder encoder;

	public UsuarioService(UsuarioRepository usuarioRepository, FuncionarioRepository funcionarioRepository,
			BCryptPasswordEncoder encoder) {
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}

	/**
	 * Criar usuário com senha criptografada
	 * 
	 * @param username
	 * @param senha
	 */
	public Usuario criarUsuario(String username, String senha) {

		Usuario u = new Usuario();
		u.setUsername(username);
		u.setSenha(encoder.encode(senha));

		return usuarioRepository.save(u);
	}

	/**
	 * Login básico manual
	 * 
	 * @param username
	 * @param senha
	 * @return
	 */
	public Usuario login(String username, String senha) {

		Usuario u = usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		// Validação de senha
		if (!encoder.matches(senha, u.getSenha()))
			throw new RuntimeException("Senha incorreta");

		return u;
	}
}
