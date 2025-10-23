package com.suaempresa.impostos;

import java.util.ArrayList;
import java.util.List;
import com.suaempresa.impostos.model.Orcamento;
import com.suaempresa.impostos.service.CalculadoraDePrecoFinal;
import com.suaempresa.impostos.service.strategy.ICMS;
import com.suaempresa.impostos.service.strategy.IPI;
import com.suaempresa.impostos.service.strategy.ISS;
import com.suaempresa.impostos.service.strategy.Imposto;


public class Main {
    
    public static void main(String[] args) {
        

        Orcamento orcamento = new Orcamento(
            1000.00, // valorProduto
            500.00,  // valorServico
            100.00,  // frete [cite: 18]
            50.00,   // seguro [cite: 18]
            300.00,  // margemLucro [cite: 5]
            "SP",    // ufOrigem [cite: 19]
            "RJ",    // ufDestino [cite: 19]
            0.05     // aliquotaIssPraticada (5%) [cite: 20]
        );

        List<Imposto> impostos = new ArrayList<>();
        impostos.add(new IPI());  // [cite: 7]
        impostos.add(new ICMS()); // [cite: 8]
        impostos.add(new ISS());  // [cite: 9]

        CalculadoraDePrecoFinal calculadora = new CalculadoraDePrecoFinal();
        double precoFinal = calculadora.calcular(orcamento, impostos);

      
        System.out.println("Cálculo do Preço Final [cite: 4]");
        System.out.println("============================");
        System.out.printf("Custo(s) (Produto + Serviço): R$ %.2f%n", 
            (orcamento.getValorProduto() + orcamento.getValorServico()));
        
        System.out.printf("Margem de Lucro: R$ %.2f%n", orcamento.getMargemLucro());
        
        System.out.println("--- Impostos Calculados [cite: 6] ---");
        
        double totalImpostos = 0;
        for (Imposto imposto : impostos) {
            double valorImposto = imposto.calcular(orcamento);
            totalImpostos += valorImposto;
            System.out.printf("%s: R$ %.2f%n", 
                imposto.getClass().getSimpleName(), valorImposto);
        }
        System.out.printf("Total Impostos: R$ %.2f%n", totalImpostos);
        
        System.out.println("============================");
        System.out.printf("PREÇO FINAL: R$ %.2f%n", precoFinal);
    }
}