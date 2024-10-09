package com.example.ExercicioSemana6.ex4.services;

import com.example.ExercicioSemana6.ex4.entities.Estoque;
import com.example.ExercicioSemana6.ex4.entities.Remedio;
import com.example.ExercicioSemana6.ex4.interfaces.AdicionarEstoqueUseCase;
import com.example.ExercicioSemana6.ex4.interfaces.SalvarRemedioUseCase;
import com.example.ExercicioSemana6.ex4.repositories.EstoqueRepository;
import com.example.ExercicioSemana6.ex4.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemedioService {

    private final SalvarRemedioUseCase salvarRemedioUseCase;
    private final AdicionarEstoqueUseCase adicionarEstoqueUseCase;

    @Autowired
    public RemedioService(SalvarRemedioUseCase salvarRemedioUseCase, AdicionarEstoqueUseCase adicionarEstoqueUseCase) {

        this.salvarRemedioUseCase = salvarRemedioUseCase;
        this.adicionarEstoqueUseCase = adicionarEstoqueUseCase;
    }

    public void salvarRemedio(String nome, Integer dosagemEmMg) {

        salvarRemedioUseCase.salvar(nome, dosagemEmMg);
    }

    public void adicionarEstoque(Integer remedioId, Integer quantidade, String remedioNome, Integer remedioDosagemMg) {

        adicionarEstoqueUseCase.adicionar(quantidade, remedioId, remedioNome, remedioDosagemMg);
    }
}
