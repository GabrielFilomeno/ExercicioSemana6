package com.example.ExercicioSemana6.ex3.strategy;

import com.example.ExercicioSemana6.ex3.entities.InformacoesPagamento;
import com.example.ExercicioSemana6.ex3.entities.PessoaPaciente;
import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.exceptions.RegraDeNegocionException;
import com.example.ExercicioSemana6.ex3.services.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SusPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private SusService susService;

    @Override
    public FormaPagamento tipoPagamento() {
        return FormaPagamento.SUS;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getCpf() == null || paciente.getNumeroPis() == null) {
            throw new RegraDeNegocionException("Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
        }

        susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
    }
}
