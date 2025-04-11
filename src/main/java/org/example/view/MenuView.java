package org.example.view;

import org.example.controllers.ContaController;
import org.example.models.Cliente;
import org.example.models.ContaCorrente;
import org.example.models.ContaPoupanca;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner = new Scanner(System.in);
    private ContaController contaController = new ContaController();

    public void exibirMenu() {
        while (true) {
            System.out.println("\n=== BANCO JAVA ===");
            System.out.println("1. Criar Conta Corrente");
            System.out.println("2. Criar Conta Poupança");
            System.out.println("3. Listar Contas");
            System.out.println("4. Depositar");
            System.out.println("5. Sacar");
            System.out.println("6. Transferir");
            System.out.println("7. Excluir Conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            String input = scanner.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido para a opção.");
                continue;
            }

            switch (opcao) {
                case 1 -> criarContaCorrente();
                case 2 -> criarContaPoupanca();
                case 3 -> contaController.mostrarTodasAsContas();
                case 4 -> depositar();
                case 5 -> sacar();
                case 6 -> transferir();
                case 7 -> excluirConta();
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private void criarContaCorrente() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        contaController.criarConta(new ContaCorrente(cliente));
    }

    private void criarContaPoupanca() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        contaController.criarConta(new ContaPoupanca(cliente));
    }

    private void depositar() {
        try {
            int numero = lerNumeroConta();
            double valor = lerValorMonetario();
            contaController.depositar(numero, valor);
        }catch (Exception e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
    }

    private void sacar() {
        try {
            int numero = lerNumeroConta();
            double valor = lerValorMonetario();
            contaController.sacar(numero, valor);
        } catch (Exception e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
    }

    private void transferir() {
        try {
            System.out.print("Conta origem: ");
            int origem = Integer.parseInt(scanner.nextLine());
            System.out.print("Conta destino: ");
            int destino = Integer.parseInt(scanner.nextLine());
            double valor = lerValorMonetario();
            contaController.transferir(origem, destino, valor);
        } catch (NumberFormatException e) {
            System.out.println("Erro: número da conta inválido.");
        } catch (Exception e) {
            System.out.println("Erro ao transferir: " + e.getMessage());
        }
    }

    private void excluirConta() {
        try {
            int numero = lerNumeroConta();
            contaController.excluirConta(numero);
        } catch (Exception e) {
            System.out.println("Erro ao excluir conta: " + e.getMessage());
        }
    }

    private int lerNumeroConta() throws Exception {
        System.out.print("Número da conta: ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new Exception("Número da conta inválido.");
        }
    }

    private double lerValorMonetario() throws Exception {
        System.out.print("Valor: ");
        String input = scanner.nextLine();
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new Exception("Valor deve ser um número válido.");
        }
    }
}
