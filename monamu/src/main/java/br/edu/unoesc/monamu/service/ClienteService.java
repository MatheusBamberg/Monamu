package br.edu.unoesc.monamu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Cliente;
import br.edu.unoesc.monamu.repository.ClienteRepository;

@Service
public class ClienteService {

	private final ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + id));
	}

	public Cliente criarCliente(Cliente cliente) {
		cliente.setDataCadastro(LocalDateTime.now());
		return clienteRepository.save(cliente);
	}

	public Cliente atualizarCliente(Integer id, Cliente novo) {
		Cliente cliente = buscarPorId(id);

		cliente.setNome(novo.getNome());
		cliente.setEmail(novo.getEmail());
		cliente.setSexo(novo.getSexo());
		cliente.setTelefone(novo.getTelefone());
		cliente.setRua(novo.getRua());
		cliente.setBairro(novo.getBairro());
		cliente.setCidade(novo.getCidade());
		cliente.setEstado(novo.getEstado());
		cliente.setCpf(novo.getCpf());

		return clienteRepository.save(cliente);
	}

	public void deletarCliente(Integer id) {
		if (!clienteRepository.existsById(id)) {
			throw new RuntimeException("Cliente não encontrado: " + id);
		}
		clienteRepository.deleteById(id);
	}

	public long contarClientes() {
		return clienteRepository.count();
	}
}
