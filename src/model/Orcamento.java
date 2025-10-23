package com.suaempresa.impostos.model;

public class Orcamento {

    private double valorProduto; 
    private double valorServico; 
    private double frete; 
    private double seguro; 
    private double margemLucro; 
    private String ufOrigem; 
    private String ufDestino; 
    private double aliquotaIssPraticada; 

    // Construtor
    public Orcamento(double valorProduto, double valorServico, double frete, double seguro, 
                     double margemLucro, String ufOrigem, String ufDestino, double aliquotaIssPraticada) {
        this.valorProduto = valorProduto;
        this.valorServico = valorServico;
        this.frete = frete;
        this.seguro = seguro;
        this.margemLucro = margemLucro;
        this.ufOrigem = ufOrigem;
        this.ufDestino = ufDestino;
        this.aliquotaIssPraticada = aliquotaIssPraticada;
    }

    // Getters
    public double getValorProduto() { return valorProduto; }
    public double getValorServico() { return valorServico; }
    public double getFrete() { return frete; }
    public double getSeguro() { return seguro; }
    public double getMargemLucro() { return margemLucro; }
    public String getUfOrigem() { return ufOrigem; }
    public String getUfDestino() { return ufDestino; }
    public double getAliquotaIssPraticada() { return aliquotaIssPraticada; }
}	