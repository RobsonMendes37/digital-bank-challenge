package org.example.models;

public abstract class Conta {
    protected static final int AGENCIA_PADRAO = 704;
    protected static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.saldo = 0;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    public void depositar(double value)throws Exception{
        if(value <= 0){
            throw new Exception("O valor a ser depositado deve ser maior que 0");
        }
        this.saldo += value;
    }

    public void sacar(double value)throws Exception{
        if(value > this.saldo){
            throw new Exception("O valor a ser sacado deve está na conta");
        }
        this.saldo -=  value;

    }

    public void transferir(double value, Conta conta) throws Exception{
        if(value > this.saldo){
            throw new Exception("O valor a ser transferido é maior do que está na conta");
        }
        this.saldo -= value;
        conta.depositar(value);

    }

    public int getAgencia() {        return agencia;    }
    public Cliente getCliente() {        return cliente;    }
    public int getNumero() {        return numero;    }
    public double getSaldo() {        return saldo;    }

    public abstract void imprimirExtrato();
}
