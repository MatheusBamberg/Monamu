package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Loja;
import br.edu.unoesc.monamu.repository.LojaRepository;

@Service
public class LojaService {

	private final LojaRepository lojaRepository;

	public LojaService(LojaRepository lojaRepository) {
		this.lojaRepository = lojaRepository;
	}

	public List<Loja> listarTodos() {
		return lojaRepository.findAll();
	}

	public Loja buscarPorId(Integer id) {
		Optional<Loja> loja = lojaRepository.findById(id);

		if (loja.isPresent()) {
			return loja.get();
		} else {
			throw new RuntimeException("Loja não encontrada: " + id);
		}
	}

	public Loja criarLoja(Loja loja) {
		return lojaRepository.save(loja);
	}

	public Loja atualizarLoja(Integer id, Loja novaLoja) {
		Loja loja = buscarPorId(id);
		loja.setNome(novaLoja.getNome());
		loja.setRua(novaLoja.getRua());
		loja.setBairro(novaLoja.getBairro());
		loja.setCidade(novaLoja.getCidade());
		loja.setTelefone(novaLoja.getTelefone());
		loja.setCnpj(novaLoja.getCnpj());

		return lojaRepository.save(loja);
	}

	public void deletarLoja(Integer id) {
		if (!lojaRepository.existsById(id)) {
			throw new RuntimeException("Loja não encontrada: " + id);
		}
		lojaRepository.deleteById(id);
	}

}
