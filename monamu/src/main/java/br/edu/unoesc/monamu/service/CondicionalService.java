package br.edu.unoesc.monamu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Condicional;
import br.edu.unoesc.monamu.repository.CondicionalRepository;

@Service
public class CondicionalService {

	private final CondicionalRepository condicionalRepository;

	public CondicionalService(CondicionalRepository condicionalRepository) {
		this.condicionalRepository = condicionalRepository;
	}

	public List<Condicional> listarTodos() {
		return condicionalRepository.findAll();
	}
	
	public Condicional buscarPorId(Integer id) {
        Optional<Condicional> condicional = condicionalRepository.findById(id);

        if (condicional.isPresent()) {
            return condicional.get();
        } else {
            throw new RuntimeException("Condicional não encontrado: " + id);
        }
    }

	public Condicional criarCondicional(Condicional condicional) {
		return condicionalRepository.save(condicional);
	}

	public Condicional atualizarCondicional(Integer id, Condicional novaCondicional) {
		Condicional condicional = buscarPorId(id);

		condicional.setNomeItem(novaCondicional.getNomeItem());
		condicional.setDataRetirada(novaCondicional.getDataRetirada());
		condicional.setDataDevolucao(novaCondicional.getDataDevolucao());
		condicional.setObservacao(novaCondicional.getObservacao());
		condicional.setCliente(novaCondicional.getCliente());

		return condicionalRepository.save(condicional);
	}

	public void deletarCondicional(Integer id) {
		if (!condicionalRepository.existsById(id)) {
			throw new RuntimeException("Condicional não encontrada: " + id);
		}
		condicionalRepository.deleteById(id);
	}
}
