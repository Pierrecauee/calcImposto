package com.suaempresa.impostos.service.strategy;

import com.suaempresa.impostos.model.Orcamento;


public interface Imposto {
    
    double calcular(Orcamento orcamento);
}