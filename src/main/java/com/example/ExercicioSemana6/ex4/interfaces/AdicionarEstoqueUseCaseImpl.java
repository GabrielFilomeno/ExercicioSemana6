package com.example.ExercicioSemana6.ex4.interfaces;

import com.example.ExercicioSemana6.ex4.entities.Estoque;
import com.example.ExercicioSemana6.ex4.entities.Remedio;
import com.example.ExercicioSemana6.ex4.exceptions.ParametroInvalidoException;
import com.example.ExercicioSemana6.ex4.repositories.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdicionarEstoqueUseCaseImpl implements AdicionarEstoqueUseCase {

    private final GaranteExistenciaRemedioUseCase garanteExistenciaRemedioUseCase;
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public AdicionarEstoqueUseCaseImpl(GaranteExistenciaRemedioUseCase garanteExistenciaRemedioUseCase, EstoqueRepository estoqueRepository) {
        this.garanteExistenciaRemedioUseCase = garanteExistenciaRemedioUseCase;
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public void adicionar(Integer quantidade, Integer remedioId, String remedioNome, Integer remedioDosagemMg) {

        validaQuantidadePositiva(quantidade);
        Remedio remedio = garanteExistenciaRemedioUseCase.obtenhaRemedio(remedioId, remedioNome, remedioDosagemMg);
        Estoque estoque = encontraEstoque(remedio);

        estoque.setIdRemedio(remedio.getId());
        estoque.setQuantidade(estoque.getQuantidade() + quantidade);

        estoqueRepository.save(estoque);
    }

    private Estoque encontraEstoque(Remedio remedio) {
        Estoque estoqueAtual = estoqueRepository.getEstoqueAtual(remedio.getId());

        if (estoqueAtual == null) {
            estoqueAtual = new Estoque();
            estoqueAtual.setQuantidade(0);
            estoqueAtual.setIdRemedio(remedio.getId());
        }

        return  estoqueAtual;
    }

    private void validaQuantidadePositiva(Integer quantidade) {
        if (quantidade < 0) {
            throw new ParametroInvalidoException("quantidade", "Quantidade adicionada no estoque não pode ser negativa");
        }
    }
}
