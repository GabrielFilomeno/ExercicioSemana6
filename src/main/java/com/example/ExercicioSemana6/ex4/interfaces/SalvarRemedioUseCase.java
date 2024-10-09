package com.example.ExercicioSemana6.ex4.interfaces;

import com.example.ExercicioSemana6.ex4.entities.Remedio;

public interface SalvarRemedioUseCase {
    Remedio salvar(String nome, Integer dosagemEmMg);
}
