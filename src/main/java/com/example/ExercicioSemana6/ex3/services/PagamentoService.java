package com.example.ExercicioSemana6.ex3.services;

import com.example.ExercicioSemana6.ex3.entities.InformacoesPagamento;
import com.example.ExercicioSemana6.ex3.entities.PessoaPaciente;
import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.exceptions.RegraDeNegocionException;
import com.example.ExercicioSemana6.ex3.factory.PagamentoStrategyFactory;
import com.example.ExercicioSemana6.ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoStrategyFactory pagamentoStrategyFactory;

    public void processaPagamento(PessoaPaciente paciente,
                                  FormaPagamento formaPagamento,
                                  InformacoesPagamento informacoesPagamento,
                                  Float valor) {

        PagamentoStrategy pagamentoStrategy = pagamentoStrategyFactory.getStrategyParaPagamento(formaPagamento);

        pagamentoStrategy.processaPagamento(paciente, informacoesPagamento, valor);

        /* Antes de usar o Strategy

        if(formaPagamento.equals(FormaPagamento.CONVENIO_UNIMED)) {
            if(paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
                throw new RegraDeNegocionException("Informações obrigatórias nao preenchidas. Preencha Numero de Convenio e CPF.");
            }
            unimedService.processaPagamento(paciente.getCpf(), paciente.getNumeroConvenio(), informacoesPagamento.getCpfMedico());
        }

        if(formaPagamento.equals(FormaPagamento.CONVENIO_BRADESCO)) {
            if(paciente.getCpf() == null) {
                throw new RegraDeNegocionException("Informaão obrigatórias nao preenchidas. Preencha o CPF.");
            }
            bradescoService.processaPagamento(paciente.getCpf(), informacoesPagamento.getCpfMedico(), valor);
        }

        if(formaPagamento.equals(FormaPagamento.SUS)) {
            if(paciente.getCpf() == null || paciente.getNumeroPis() == null) {
                throw new RegraDeNegocionException("Informações obrigatórias nao preenchidas. Preencha Numero do PIS e CPF.");
            }

            susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
        }

        if(formaPagamento.equals(FormaPagamento.PIX)) {
            if(informacoesPagamento.getIdTransacaoPix() != null) {
                bacenService.processaPix(informacoesPagamento.getIdTransacaoPix(), valor);
            }
            else {
                bacenService.geraChavePixParaPagamento(paciente.getChavePix(), valor);
            }
        }
         */
    }

}
