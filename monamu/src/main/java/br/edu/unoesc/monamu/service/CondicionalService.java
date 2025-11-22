package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Condicional;
import br.edu.unoesc.monamu.model.ItemCondicional;
import br.edu.unoesc.monamu.model.Produto;
import br.edu.unoesc.monamu.repository.CondicionalRepository;
import br.edu.unoesc.monamu.repository.ProdutoRepository;

@Service
public class CondicionalService {

	private final CondicionalRepository condicionalRepository;
	private final ProdutoRepository produtoRepository;

	public CondicionalService(CondicionalRepository condicionalRepository, ProdutoRepository produtoRepository) {
		this.condicionalRepository = condicionalRepository;
		this.produtoRepository = produtoRepository;
	}

	public List<Condicional> listarTodos() {
		return condicionalRepository.findAll();
	}

	public Condicional buscarPorId(Integer id) {
		Optional<Condicional> condicional = condicionalRepository.findById(id);

		if (condicional.isPresent()) {
			return condicional.get();
		} else {
			throw new RuntimeException("Condicional não encontrada: " + id);
		}
	}

	private void validarDatas(Condicional condicional) {
		if (condicional.getDataRetirada() == null || condicional.getDataDevolucao() == null) {
			return;
		}

		if (!condicional.getDataDevolucao().isAfter(condicional.getDataRetirada())) {
			throw new RuntimeException("A data de devolução deve ser DEPOIS da data de retirada.");
		}
	}

	public Condicional criarCondicional(Condicional condicional) {

		validarDatas(condicional);

		if (condicional.getItens() != null) {
			for (ItemCondicional item : condicional.getItens()) {

				Optional<Produto> optProduto = produtoRepository.findById(item.getProduto().getId());

				if (!optProduto.isPresent()) {
					throw new RuntimeException("Produto não encontrado");
				}

				Produto produto = optProduto.get();

				if (produto.getQuantidadeEstoque() == null
						|| produto.getQuantidadeEstoque() < item.getQuantidadeItem()) {

					throw new RuntimeException("O produto \"" + produto.getNome()
							+ "\" não possui estoque suficiente. Estoque atual: " + produto.getQuantidadeEstoque());
				}

				item.setCondicional(condicional);
			}
		}

		return condicionalRepository.save(condicional);
	}

	public Condicional atualizarCondicional(Integer id, Condicional novaCondicional) {
		Condicional condicionalExistente = buscarPorId(id);
		validarDatas(novaCondicional);

		condicionalExistente.setNomeItem(novaCondicional.getNomeItem());
		condicionalExistente.setDataRetirada(novaCondicional.getDataRetirada());
		condicionalExistente.setDataDevolucao(novaCondicional.getDataDevolucao());
		condicionalExistente.setObservacao(novaCondicional.getObservacao());
		condicionalExistente.setCliente(novaCondicional.getCliente());
		condicionalExistente.getItens().clear();

		if (novaCondicional.getItens() != null) {
			for (ItemCondicional item : novaCondicional.getItens()) {
				item.setCondicional(condicionalExistente);
				condicionalExistente.getItens().add(item);
			}
		}

		return condicionalRepository.save(condicionalExistente);
	}

	public void deletarCondicional(Integer id) {
		if (!condicionalRepository.existsById(id)) {
			throw new RuntimeException("Condicional não encontrada: " + id);
		}
		condicionalRepository.deleteById(id);
	}
}
