package org.example.models;

public class ContaPoupanca extends Conta{
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.printf("Titular: %s%nAgência: %d%nNúmero: %d%nSaldo: %.2f%n",
                cliente.getName(), agencia, numero, saldo);
    }
}
