package com.example.ExercicioSemana6.ex3;

import com.example.ExercicioSemana6.ex3.entities.InformacoesPagamento;
import com.example.ExercicioSemana6.ex3.entities.PessoaPaciente;
import com.example.ExercicioSemana6.ex3.enums.FormaPagamento;
import com.example.ExercicioSemana6.ex3.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoTesteComponent {

    @Autowired
    public PagamentoTesteComponent(PagamentoService service) {
        PessoaPaciente gabriel = new PessoaPaciente();
        InformacoesPagamento informacoesPagamentoPixGabriel = new InformacoesPagamento();
        service.processaPagamento(gabriel, FormaPagamento.CONVENIO_UNIMED, informacoesPagamentoPixGabriel, 50.0f);
    }


}
