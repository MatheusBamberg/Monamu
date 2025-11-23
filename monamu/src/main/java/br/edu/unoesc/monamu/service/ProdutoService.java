package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Produto;
import br.edu.unoesc.monamu.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Produto buscarPorId(Integer id) {
		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {
			return produto.get();
		} else {
			throw new RuntimeException("Produto não encontrado: " + id);
		}
	}

	public Produto criarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto atualizarProduto(Integer id, Produto novaProduto) {
		Produto produto = buscarPorId(id);

		produto.setNome(novaProduto.getNome());
		produto.setTamanho(novaProduto.getTamanho());
		produto.setCor(novaProduto.getCor());
		produto.setTipo(novaProduto.getTipo());
		produto.setCusto(novaProduto.getCusto());
		produto.setVenda(novaProduto.getVenda());
		produto.setQuantidadeEstoque(novaProduto.getQuantidadeEstoque());
		produto.setDescricao(novaProduto.getDescricao());
		produto.setAtivo(novaProduto.getAtivo());
		produto.setLoja(novaProduto.getLoja());
		produto.setFornecedor(novaProduto.getFornecedor());

		return produtoRepository.save(produto);
	}

	public List<Produto> listarApenasComEstoque() {
		return produtoRepository.findByQuantidadeEstoqueGreaterThan(0);
	}

	public void deletarProduto(Integer id) {
		Produto existente = buscarPorId(id);
		produtoRepository.delete(existente);
	}

	public long contarProdutos() {
		return produtoRepository.count();
	}

	public long contarProdutosComEstoque() {
		return produtoRepository.countByQuantidadeEstoqueGreaterThan(0);
	}

	public List<Produto> listarEstoqueBaixo(int limite) {
		return produtoRepository.findByQuantidadeEstoqueLessThanEqual(limite);
	}
}
