package view;

import java.util.ArrayList;
import java.util.List;
import model.Orcamento;
import service.CalculadoraDePrecoFinal;
import service.ICMS;
import service.IPI;
import service.ISS;
import service.Imposto;

public class Main {
    
    public static void main(String[] args) {
        
        Orcamento orcamento = new Orcamento(
            1000.00, // valorProduto
            500.00,  // valorServico
            100.00,  // frete
            50.00,   // seguro
            300.00,  // margemLucro
            "SP",    // ufOrigem
            "RJ",    // ufDestino
            0.05     // aliquotaIssPraticada (5%)
        );

        List<Imposto> impostos = new ArrayList<>();
        impostos.add(new IPI());
        impostos.add(new ICMS());
        impostos.add(new ISS());

        CalculadoraDePrecoFinal calculadora = new CalculadoraDePrecoFinal();
        double precoFinal = calculadora.calcular(orcamento, impostos);

        System.out.println("Cálculo do Preço Final");
        System.out.println("============================");
        System.out.printf("Custo(s) (Produto + Serviço): R$ %.2f%n", 
            (orcamento.getValorProduto() + orcamento.getValorServico()));
        
        System.out.printf("Margem de Lucro: R$ %.2f%n", orcamento.getMargemLucro());
        
        System.out.println("--- Impostos Calculados ---");
        
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