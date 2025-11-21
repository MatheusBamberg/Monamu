package br.edu.unoesc.monamu.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.ItemVenda;
import br.edu.unoesc.monamu.model.Produto;
import br.edu.unoesc.monamu.model.Venda;
import br.edu.unoesc.monamu.repository.ItemVendaRepository;
import br.edu.unoesc.monamu.repository.ProdutoRepository;
import br.edu.unoesc.monamu.repository.VendaRepository;

@Service
public class ItemVendaService {

	private final ItemVendaRepository itemVendaRepository;
	private final VendaRepository vendaRepository;
	private final ProdutoRepository produtoRepository;

	public ItemVendaService(ItemVendaRepository itemVendaRepository, VendaRepository vendaRepository,
			ProdutoRepository produtoRepository) {
		this.itemVendaRepository = itemVendaRepository;
		this.vendaRepository = vendaRepository;
		this.produtoRepository = produtoRepository;
	}

	public List<ItemVenda> listarTodos() {
		return itemVendaRepository.findAll();
	}

	public ItemVenda buscarPorId(Integer id) {
		Optional<ItemVenda> item = itemVendaRepository.findById(id);
		if (item.isPresent()) {
			return item.get();
		} else {
			throw new RuntimeException("ItemVenda não encontrado: " + id);
		}
	}

	public ItemVenda criarItemVenda(ItemVenda item) {

		Optional<Venda> vendaOpt = vendaRepository.findById(item.getVenda().getId());
		if (!vendaOpt.isPresent()) {
			throw new RuntimeException("Venda não encontrada");
		}

		Optional<Produto> produtoOpt = produtoRepository.findById(item.getProduto().getId());
		if (!produtoOpt.isPresent()) {
			throw new RuntimeException("Produto não encontrado");
		}

		Venda venda = vendaOpt.get();
		Produto produto = produtoOpt.get();

		item.setVenda(venda);
		item.setProduto(produto);

		// Calcula valor total do item
		BigDecimal qtd = new BigDecimal(item.getQuantidadeItem());
		BigDecimal total = produto.getVenda().multiply(qtd);

		item.setValorUnitario(produto.getVenda());
		item.setValorTotal(total);

		return itemVendaRepository.save(item);
	}

	public ItemVenda atualizarItemVenda(Integer id, ItemVenda novo) {
		Optional<ItemVenda> itemOpt = itemVendaRepository.findById(id);
		if (!itemOpt.isPresent()) {
			throw new RuntimeException("ItemVenda não encontrado: " + id);
		}

		ItemVenda item = itemOpt.get();

		Optional<Produto> produtoOpt = produtoRepository.findById(novo.getProduto().getId());
		if (!produtoOpt.isPresent()) {
			throw new RuntimeException("Produto não encontrado");
		}

		Produto produto = produtoOpt.get();

		item.setQuantidadeItem(novo.getQuantidadeItem());
		item.setProduto(produto);

		BigDecimal qtd = new BigDecimal(item.getQuantidadeItem());
		item.setValorUnitario(produto.getVenda());
		item.setValorTotal(produto.getVenda().multiply(qtd));

		return itemVendaRepository.save(item);
	}

	public void deletarItemVenda(Integer id) {
		if (!itemVendaRepository.existsById(id)) {
			throw new RuntimeException("ItemVenda não encontrado: " + id);
		}
		itemVendaRepository.deleteById(id);
	}
}
