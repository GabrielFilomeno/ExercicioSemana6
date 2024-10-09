package com.example.ExercicioSemana6.ex4.interfaces;

import com.example.ExercicioSemana6.ex4.entities.Remedio;
import com.example.ExercicioSemana6.ex4.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GaranteExistenciaRemedioUseCaseImpl implements GaranteExistenciaRemedioUseCase {

    private final RemedioRepository remedioRepository;
    private final SalvarRemedioUseCase salvarRemedioUseCase;

    public GaranteExistenciaRemedioUseCaseImpl(RemedioRepository remedioRepository, SalvarRemedioUseCase salvarRemedioUseCase) {
        this.remedioRepository = remedioRepository;
        this.salvarRemedioUseCase = salvarRemedioUseCase;
    }


    @Override
    public Remedio obtenhaRemedio(Integer remedioId, String remedioNome, Integer remedioDosagemMg) {
        if (remedioRepository.existe(remedioId)) {
            return remedioRepository.getRemedioPorId(remedioId);
        }

        if (remedioRepository.existePorNome(remedioNome)) {
            return remedioRepository.getRemedioPorNome(remedioNome);
        }


        return salvarRemedioUseCase.salvar(remedioNome, remedioDosagemMg);
    }
}
