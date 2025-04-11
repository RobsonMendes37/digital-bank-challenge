package org.example.repository;
import org.example.models.Conta;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//Simula um banco de dados usando uma lista de contas (List<Conta>).
//
//Funções principais:
//salvar(Conta): adiciona uma conta à lista.
//listarTodas(): retorna todas as contas.
//removerConta(Conta): remove uma conta da lista.
//buscarConta(int numero): busca uma conta por número (com Optional).

public class ContaRepository {
    private List<Conta> contas = new ArrayList<>(); // é como o banco de dados

    //metodos para acessar esse banco
    public void salvar(Conta conta){
        contas.add(conta);
    }

    public List<Conta> listarTodas(){
        return contas;
    }

    public void removerConta(Conta conta) throws Exception{
        if(!contas.contains(conta)) throw new Exception("Conta não está no banco de dados");
        contas.remove(conta);
    }

    public Optional<Conta> buscarConta(int numero) throws Exception{
        Optional<Conta> conta = contas.stream().filter(c -> c.getNumero() == numero).findFirst();

        if(conta.isEmpty()){
            throw new Exception("Conta numero "+numero+ " não encontrada");
        }
        return conta;
    }

}
