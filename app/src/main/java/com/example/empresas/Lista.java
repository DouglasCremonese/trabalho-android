package com.example.empresas;

public class Lista {

    private int id;
    private String nome;


    @Override
    public String toString() { return this.nome; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    }

