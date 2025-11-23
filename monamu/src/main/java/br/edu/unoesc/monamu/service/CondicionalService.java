package br.edu.unoesc.monamu.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

		condicional.setDevolvido(false);

		if (condicional.getItens() != null) {
			for (ItemCondicional item : condicional.getItens()) {

				Produto produto = produtoRepository.findById(item.getProduto().getId())
						.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

				if (produto.getQuantidadeEstoque() < item.getQuantidadeItem()) {
					throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
				}

				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidadeItem());
				produtoRepository.save(produto);

				item.setCondicional(condicional);
			}
		}

		return condicionalRepository.save(condicional);
	}

	public Condicional atualizarCondicional(Integer id, Condicional novaCondicional) {

		Condicional antiga = buscarPorId(id);
		validarDatas(novaCondicional);

		// Devolver ao estoque atual
		if (antiga.getItens() != null) {
			for (ItemCondicional itemAntigo : antiga.getItens()) {

				Produto produto = produtoRepository.findById(itemAntigo.getProduto().getId()).orElse(null);

				if (produto != null) {
					produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + itemAntigo.getQuantidadeItem());
					produtoRepository.save(produto);
				}
			}
		}

		antiga.getItens().clear();

		// Subtrair para os novos itens adicionados
		if (novaCondicional.getItens() != null) {
			for (ItemCondicional itemNovo : novaCondicional.getItens()) {

				Produto produto = produtoRepository.findById(itemNovo.getProduto().getId())
						.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

				if (produto.getQuantidadeEstoque() < itemNovo.getQuantidadeItem()) {
					throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
				}

				// Subtrair do estoque
				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - itemNovo.getQuantidadeItem());
				produtoRepository.save(produto);

				itemNovo.setCondicional(antiga);
				antiga.getItens().add(itemNovo);
			}
		}

		antiga.setNomeItem(novaCondicional.getNomeItem());
		antiga.setDataRetirada(novaCondicional.getDataRetirada());
		antiga.setDataDevolucao(novaCondicional.getDataDevolucao());
		antiga.setObservacao(novaCondicional.getObservacao());
		antiga.setCliente(novaCondicional.getCliente());

		return condicionalRepository.save(antiga);
	}

	public Condicional marcarComoDevolvido(Integer id) {

		Condicional condicional = buscarPorId(id);

		if (condicional.getDevolvido() != null && condicional.getDevolvido()) {
			throw new RuntimeException("Condicional já devolvida.");
		}

		condicional.setDevolvido(true);
		condicional.setDataDevolucao(LocalDateTime.now());

		// Somar estoque de volta
		if (condicional.getItens() != null) {
			for (ItemCondicional item : condicional.getItens()) {

				Produto produto = produtoRepository.findById(item.getProduto().getId()).orElse(null);

				if (produto != null) {
					produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + item.getQuantidadeItem());
					produtoRepository.save(produto);
				}
			}
		}

		return condicionalRepository.save(condicional);
	}

	public void deletarCondicional(Integer id) {
		condicionalRepository.deleteById(id);
	}

	public long contarCondicionaisAtivas() {
		return condicionalRepository.countByDevolvidoFalse();
	}

	public List<Condicional> listarCondicionaisVencendoHoje() {
		LocalDate hoje = LocalDate.now();
		return condicionalRepository.findByDataDevolucaoBetweenAndDevolvidoFalse(hoje.atStartOfDay(),
				hoje.atTime(LocalTime.MAX));
	}

}
