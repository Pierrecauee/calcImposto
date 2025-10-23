package service;

import model.Orcamento;

public class ICMS implements Imposto {

    @Override
    public double calcular(Orcamento orcamento) {
        
        double aliquota = 0.0;
        String origem = orcamento.getUfOrigem();
        String destino = orcamento.getUfDestino();

        if ("SP".equalsIgnoreCase(origem) && "RJ".equalsIgnoreCase(destino)) {
            aliquota = 0.12; 
        } 
        else if ("SP".equalsIgnoreCase(origem) && "DF".equalsIgnoreCase(destino)) {
            aliquota = 0.07;
        }
        
        return orcamento.getValorProduto() * aliquota;
    }
}