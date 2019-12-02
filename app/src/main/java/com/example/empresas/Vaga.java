package com.example.empresas;

public class Vaga {

    private int    idVaga;
    private String nomeVaga;
    private int numeroCamisa;

    public Vaga() {
    }

    public Vaga(String nomeProduto) {
        this.nomeVaga = nomeProduto;
    }

    public Vaga(String nomeProduto, int valor) {
        this.nomeVaga = nomeProduto;
        this.numeroCamisa = valor;
    }

    public Vaga(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(int idVaga) {this.idVaga = idVaga;}

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public double getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }
}
