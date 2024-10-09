package com.example.ExercicioSemana6.ex4.interfaces;

import com.example.ExercicioSemana6.ex4.entities.Remedio;
import com.example.ExercicioSemana6.ex4.exceptions.ParametroInvalidoException;
import com.example.ExercicioSemana6.ex4.repositories.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SalvarRemedioUseCaseImpl implements SalvarRemedioUseCase {

    @Autowired
    private RemedioRepository remedioRepository;

    @Override
    public Remedio salvar(String nome, Integer dosagemEmMg) {

        validaExistenciaDeNome(nome);
        validaDosagem(dosagemEmMg);
        Remedio remedio = new Remedio();
        remedio.setNome(nome);
        remedio.dosagemMg(dosagemEmMg);

        remedioRepository.save(remedio);

        return remedio;
    }

    private void validaExistenciaDeNome(String nome) {
        if (nome == null || nome.isEmpty() || nome.trim().isEmpty()) {
            throw new ParametroInvalidoException("Quantidade", "Nome do remédio não pode ser vazio");
        }
    }

    private void validaDosagem(Integer dosagemEmMg) {
        if (dosagemEmMg == null) {
            throw new ParametroInvalidoException("DosagemEmMg","Remédio precisa possuir dosagem");
        }
        if (dosagemEmMg < 0) {
            throw new ParametroInvalidoException("DosagemEmMg", "Dosagem não pode ser negativa");
        }
    }
}
