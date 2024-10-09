package com.example.ExercicioSemana6.ex3.strategy;

import com.example.ExercicioSemana6.ex3.entities.InformacoesPagamento;
import com.example.ExercicioSemana6.ex3.entities.PessoaPaciente;
import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.exceptions.RegraDeNegocionException;
import com.example.ExercicioSemana6.ex3.services.BradescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvenioBradescoPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private BradescoService bradescoService;

    @Override
    public FormaPagamento tipoPagamento() {
        return FormaPagamento.CONVENIO_BRADESCO;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getCpf() == null) {
            throw new RegraDeNegocionException("Informaão obrigatórias nao preenchidas. Preencha o CPF.");
        }
        bradescoService.processaPagamento(paciente.getCpf(), informacoesPagamento.getCpfMedico(), valor);
    }
}
