package com.example.ExercicioSemana6.ex4.interfaces;

import com.example.ExercicioSemana6.ex4.entities.Remedio;

public interface GaranteExistenciaRemedioUseCase {
    Remedio obtenhaRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg);
}
