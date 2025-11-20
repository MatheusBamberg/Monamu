package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Fornecedor;
import br.edu.unoesc.monamu.repository.FornecedorRepository;

@Service
public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}

	public Fornecedor buscarPorId(Integer id) {
		Optional<Fornecedor> fornecedor = fornecedorRepository.findById(id);

		if (fornecedor.isPresent()) {
			return fornecedor.get();
		} else {
			throw new RuntimeException("Fornecedor não encontrado: " + id);
		}
	}

	public Fornecedor criarFornecedor(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public Fornecedor atualizarFornecedor(Integer id, Fornecedor fornecedorAtualizado) {
		Fornecedor fornecedorExistente = buscarPorId(id);

		fornecedorExistente.setNome(fornecedorAtualizado.getNome());
		fornecedorExistente.setEmail(fornecedorAtualizado.getEmail());
		fornecedorExistente.setSexo(fornecedorAtualizado.getSexo());
		fornecedorExistente.setTelefone(fornecedorAtualizado.getTelefone());
		fornecedorExistente.setRua(fornecedorAtualizado.getRua());
		fornecedorExistente.setBairro(fornecedorAtualizado.getBairro());
		fornecedorExistente.setCidade(fornecedorAtualizado.getCidade());
		fornecedorExistente.setEstado(fornecedorAtualizado.getEstado());
		fornecedorExistente.setCnpj(fornecedorAtualizado.getCnpj());
		fornecedorExistente.setNomeFantasia(fornecedorAtualizado.getNomeFantasia());

		return fornecedorRepository.save(fornecedorExistente);
	}

	public void deletarFornecedor(Integer id) {
		Fornecedor fornecedor = buscarPorId(id);
		fornecedorRepository.delete(fornecedor);
	}
}
