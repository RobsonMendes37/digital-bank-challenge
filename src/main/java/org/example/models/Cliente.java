package org.example.models;
//Essas classes representam os objetos do mundo real que o sistema manipula (clientes e contas bancárias).
public class Cliente {
    private String name;

    public Cliente(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
