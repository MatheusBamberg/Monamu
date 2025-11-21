package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Desconto;
import br.edu.unoesc.monamu.model.ItemCondicional;
import br.edu.unoesc.monamu.repository.ItemCondicionalRepository;

@Service
public class ItemCondicionalService {

	private final ItemCondicionalRepository itemRepository;

	public ItemCondicionalService(ItemCondicionalRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public List<ItemCondicional> listarTodos() {
		return itemRepository.findAll();
	}

	
	public ItemCondicional buscarPorId(Integer id) {
        Optional<ItemCondicional> itemCondicional = itemRepository.findById(id);

        if (itemCondicional.isPresent()) {
            return itemCondicional.get();
        } else {
            throw new RuntimeException("Item condicional não encontrado: " + id);
        }
    }

	public ItemCondicional criarItem(ItemCondicional item) {
		return itemRepository.save(item);
	}

	public ItemCondicional atualizarItem(Integer id, ItemCondicional novoItem) {
		ItemCondicional item = buscarPorId(id);

		item.setQuantidadeItem(novoItem.getQuantidadeItem());
		item.setCondicional(novoItem.getCondicional());
		item.setProduto(novoItem.getProduto());

		return itemRepository.save(item);
	}

	public void deletarItem(Integer id) {
		if (!itemRepository.existsById(id)) {
			throw new RuntimeException("Item condicional não encontrado: " + id);
		}
		itemRepository.deleteById(id);
	}
}
