package com.example.ExercicioSemana6.ex3.factory;

import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PagamentoStrategyFactory {

    @Autowired
    private List<PagamentoStrategy> strategies;

    public PagamentoStrategy getStrategyParaPagamento(FormaPagamento formaPagamento) {

        for (PagamentoStrategy strategy : strategies) {
            if (strategy.tipoPagamento().equals(formaPagamento)) {
                return strategy;
            }
        }

        return null;
    }
}
