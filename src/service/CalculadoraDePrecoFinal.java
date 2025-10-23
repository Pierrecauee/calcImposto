package service;

import java.util.List;
import model.Orcamento;

public class CalculadoraDePrecoFinal {

    public double calcular(Orcamento orcamento, List<Imposto> impostos) {
        
        double custos = orcamento.getValorProduto() + orcamento.getValorServico();

        double totalImpostos = 0;
        for (Imposto imposto : impostos) {
            totalImpostos += imposto.calcular(orcamento);
        }

        double margem = orcamento.getMargemLucro();

        return custos + totalImpostos + margem;
    }
}