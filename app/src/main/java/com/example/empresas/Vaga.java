package com.example.empresas;

public class Vaga {

    private int    idVaga;
    private String nomeVaga;
    private double valorSalario;

    public Vaga() {
    }

    public Vaga(String nomeProduto) {
        this.nomeVaga = nomeProduto;
    }

    public Vaga(String nomeProduto, int valor) {
        this.nomeVaga = nomeProduto;
        this.valorSalario = valor;
    }

    public Vaga(double valorSalario) {
        this.valorSalario = valorSalario;
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

    public double getValorSalario() {
        return valorSalario;
    }

    public void setValorSalario(double valorSalario) {
        this.valorSalario = valorSalario;
    }
}
