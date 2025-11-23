package br.edu.unoesc.monamu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Funcionario;
import br.edu.unoesc.monamu.model.Loja;
import br.edu.unoesc.monamu.repository.FuncionarioRepository;
import br.edu.unoesc.monamu.repository.LojaRepository;

@Service
public class FuncionarioService {

	private final FuncionarioRepository funcionarioRepository;
	private final LojaRepository lojaRepository;

	public FuncionarioService(FuncionarioRepository funcionarioRepository, LojaRepository lojaRepository) {
		this.funcionarioRepository = funcionarioRepository;
		this.lojaRepository = lojaRepository;
	}

	/**
	 * Lista todos os funcionários.
	 * @return Uma lista de todos os funcionários.
	 */
	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	/**
	 * Busca um funcionário pelo seu ID.
	 * @param id O ID do funcionário a ser buscado.
	 * @return O funcionário encontrado.
	 * @throws RuntimeException Se o funcionário não for encontrado.
	 */
	public Funcionario buscarPorId(Integer id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

		if (funcionario.isPresent()) {
			return funcionario.get();
		} else {
			throw new RuntimeException("Funcionário não encontrado: " + id);
		}
	}

	/**
	 * Cria um novo funcionário, verifica se a loja existe e define a data de admissão para o momento atual.
	 * @param funcionario O funcionário a ser criado.
	 * @return O funcionário salvo.
	 * @throws RuntimeException Se a loja do funcionário não for encontrada.
	 */
	public Funcionario criarFuncionario(Funcionario funcionario) {

		// verifica se a loja existe
		Loja loja = lojaRepository.findById(funcionario.getLoja().getId())
				.orElseThrow(() -> new RuntimeException("Loja não encontrada: " + funcionario.getLoja().getId()));

		funcionario.setLoja(loja);
		funcionario.setDataAdmissao(LocalDateTime.now());

		return funcionarioRepository.save(funcionario);
	}

	/**
	 * Atualiza um funcionário existente com novos dados.
	 * @param id O ID do funcionário a ser atualizado.
	 * @param novoFuncionario O objeto funcionário com os novos dados.
	 * @return O funcionário atualizado.
	 * @throws RuntimeException Se o funcionário não for encontrado.
	 */
	public Funcionario atualizarFuncionario(Integer id, Funcionario novoFuncionario) {
		Funcionario funcionario = buscarPorId(id);

		funcionario.setNome(novoFuncionario.getNome());
		funcionario.setCpf(novoFuncionario.getCpf());
		funcionario.setCargo(novoFuncionario.getCargo());
		funcionario.setSenha(novoFuncionario.getSenha());
		funcionario.setTelefone(novoFuncionario.getTelefone());
		funcionario.setEmail(novoFuncionario.getEmail());
		funcionario.setSexo(novoFuncionario.getSexo());
		funcionario.setRua(novoFuncionario.getRua());
		funcionario.setBairro(novoFuncionario.getBairro());
		funcionario.setCidade(novoFuncionario.getCidade());
		funcionario.setLoja(novoFuncionario.getLoja());

		return funcionarioRepository.save(funcionario);
	}

	/**
	 * Deleta um funcionário pelo seu ID.
	 * @param id O ID do funcionário a ser deletado.
	 * @throws RuntimeException Se o funcionário não for encontrado.
	 */
	public void deletarFuncionario(Integer id) {
		if (!funcionarioRepository.existsById(id)) {
			throw new RuntimeException("Funcionário não encontrado: " + id);
		}
		funcionarioRepository.deleteById(id);
	}
}