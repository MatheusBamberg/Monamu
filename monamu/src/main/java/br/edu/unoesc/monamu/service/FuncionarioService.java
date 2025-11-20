package br.edu.unoesc.monamu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.edu.unoesc.monamu.model.Funcionario;
import br.edu.unoesc.monamu.model.Loja;
import br.edu.unoesc.monamu.repository.FuncionarioRepository;
import br.edu.unoesc.monamu.repository.LojaRepository;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final LojaRepository lojaRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, LojaRepository lojaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.lojaRepository = lojaRepository;
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Integer id) {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado: " + id);
        }
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {

        // verifica se a loja existe
        Loja loja = lojaRepository.findById(funcionario.getLoja().getId())
                .orElseThrow(() -> new RuntimeException("Loja não encontrada: " + funcionario.getLoja().getId()));

        funcionario.setLoja(loja);
        funcionario.setDataAdmissao(LocalDateTime.now());

        return funcionarioRepository.save(funcionario);
    }


    public Funcionario atualizarFuncionario(Integer id, Funcionario novoFuncionario) {
        Funcionario funcionario = buscarPorId(id);

        funcionario.setNome(novoFuncionario.getNome());
        funcionario.setCpf(novoFuncionario.getCpf());
        funcionario.setCargo(novoFuncionario.getCargo());
        funcionario.setSenha(novoFuncionario.getSenha());
        funcionario.setTelefone(novoFuncionario.getTelefone());
        funcionario.setEmail(novoFuncionario.getEmail());
        funcionario.setSexo(novoFuncionario.getSexo());
        funcionario.setRua(novoFuncionario.getRua());
        funcionario.setBairro(novoFuncionario.getBairro());
        funcionario.setCidade(novoFuncionario.getCidade());
        funcionario.setLoja(novoFuncionario.getLoja());

        return funcionarioRepository.save(funcionario);
    }


    public void deletarFuncionario(Integer id) {
        if (!funcionarioRepository.existsById(id)) {
            throw new RuntimeException("Funcionário não encontrado: " + id);
        }
        funcionarioRepository.deleteById(id);
    }
}
