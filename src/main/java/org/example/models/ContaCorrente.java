package org.example.models;

public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente){
        super(cliente);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.printf("Titular: %s%nAgência: %d%nNúmero: %d%nSaldo: %.2f%n",
                cliente.getName(), agencia, numero, saldo);
    }
}
