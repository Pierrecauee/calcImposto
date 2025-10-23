package service;

import model.Orcamento;

public class IPI implements Imposto {

    @Override
    public double calcular(Orcamento orcamento) {
        double baseCalculo = orcamento.getValorProduto() + 
                             orcamento.getFrete() + 
                             orcamento.getSeguro();
        
        return baseCalculo * 0.0015; 
    }
}