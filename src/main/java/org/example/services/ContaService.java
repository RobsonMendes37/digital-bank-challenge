package org.example.services;

import org.example.models.Conta;
import org.example.repository.ContaRepository;

import java.util.List;
import java.util.Optional;
//Camada onde fica a lógica de negócio do sistema. Ela orquestra as ações entre o repository e o controller.
//criarConta(Conta)
//listarContas()
//excluirConta(int)
//buscarConta(int)
//transferir(int origem, int destino, double valor)

public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public void criarConta(Conta conta) {
        contaRepository.salvar(conta);
    }

    public List<Conta> listarContas() {
        return contaRepository.listarTodas();
    }

    public void excluirConta(int numeroConta) throws Exception {
        Conta conta = buscarConta(numeroConta);
        contaRepository.removerConta(conta);
    }

    public Conta buscarConta(int numeroConta) throws Exception {
        Optional<Conta> conta = contaRepository.buscarConta(numeroConta);
        if (conta.isEmpty()) {
            throw new Exception("Conta número " + numeroConta + " não encontrada");
        }
        return conta.get();
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) throws Exception {
        Conta origem = buscarConta(numeroOrigem);
        Conta destino = buscarConta(numeroDestino);
        origem.transferir(valor, destino);
    }
}
