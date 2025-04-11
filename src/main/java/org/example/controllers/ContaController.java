package org.example.controllers;
import org.example.models.Conta;
import org.example.repository.ContaRepository;
import org.example.services.ContaService;
import java.util.List;

//Recebe ações do usuário (na view), chama o service e retorna a resposta.
//criarConta(Conta)
//mostrarTodasAsContas()
//excluirConta(int)
//transferir(...)
//depositar(...)
//sacar(...)

public class ContaController {
    private final ContaService contaService;

    public ContaController(){
        ContaRepository contaRepository = new ContaRepository();
        this.contaService =  new ContaService(contaRepository);
    }

    public void criarConta(Conta conta) {
        contaService.criarConta(conta);
    }

    public void mostrarTodasAsContas() {
        List<Conta> contas = contaService.listarContas();
        for (Conta conta : contas) {
            conta.imprimirExtrato();
        }
    }

    public void excluirConta(int numeroConta) {
        try {
            contaService.excluirConta(numeroConta);
            System.out.println("Conta removida com sucesso.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        try {
            contaService.transferir(numeroOrigem, numeroDestino, valor);
            System.out.println("Transferência realizada com sucesso!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositar(int numeroConta, double valor) {
        try {
            Conta conta = contaService.buscarConta(numeroConta);
            conta.depositar(valor);
            System.out.println("Depósito realizado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sacar(int numeroConta, double valor) {
        try {
            Conta conta = contaService.buscarConta(numeroConta);
            conta.sacar(valor);
            System.out.println("Saque realizado!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
