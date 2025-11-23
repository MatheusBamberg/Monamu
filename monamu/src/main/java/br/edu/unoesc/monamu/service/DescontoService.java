package br.edu.unoesc.monamu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Desconto;
import br.edu.unoesc.monamu.repository.DescontoRepository;

@Service
public class DescontoService {

	private final DescontoRepository descontoRepository;

	public DescontoService(DescontoRepository descontoRepository) {
		this.descontoRepository = descontoRepository;
	}

	public List<Desconto> listarTodos() {
		return descontoRepository.findAll();
	}

	public Desconto buscarPorId(Integer id) {
		Optional<Desconto> desconto = descontoRepository.findById(id);

		if (desconto.isPresent()) {
			return desconto.get();
		} else {
			throw new RuntimeException("Desconto não encontrado: " + id);
		}
	}

	public Desconto criarDesconto(Desconto desconto) {
		desconto.setDataCadastro(LocalDateTime.now());
		return descontoRepository.save(desconto);
	}

	public Desconto atualizarDesconto(Integer id, Desconto novo) {
		Desconto desconto = buscarPorId(id);

		desconto.setNome(novo.getNome());
		desconto.setValor(novo.getValor());
		desconto.setDataValidade(novo.getDataValidade());
		desconto.setVenda(novo.getVenda());

		return descontoRepository.save(desconto);
	}

	public void deletarDesconto(Integer id) {
		if (!descontoRepository.existsById(id)) {
			throw new RuntimeException("Desconto não encontrado: " + id);
		}
		descontoRepository.deleteById(id);
	}
}
