package service;

import model.Orcamento;

public class ISS implements Imposto {

    @Override
    public double calcular(Orcamento orcamento) {
        return orcamento.getAliquotaIssPraticada() * orcamento.getValorServico();
    }
}