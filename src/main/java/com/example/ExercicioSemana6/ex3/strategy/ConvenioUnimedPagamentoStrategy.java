package com.example.ExercicioSemana6.ex3.strategy;

import com.example.ExercicioSemana6.ex3.entities.InformacoesPagamento;
import com.example.ExercicioSemana6.ex3.entities.PessoaPaciente;
import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.exceptions.RegraDeNegocionException;
import com.example.ExercicioSemana6.ex3.services.UnimedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvenioUnimedPagamentoStrategy implements PagamentoStrategy {

    @Autowired
    private UnimedService unimedService;

    @Override
    public FormaPagamento tipoPagamento() {
        return FormaPagamento.CONVENIO_UNIMED;
    }

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if(paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
            throw new RegraDeNegocionException("Informações obrigatórias nao preenchidas. Preencha Numero de Convenio e CPF.");
        }
        unimedService.processaPagamento(paciente.getCpf(), paciente.getNumeroConvenio(), informacoesPagamento.getCpfMedico());
    }
}
