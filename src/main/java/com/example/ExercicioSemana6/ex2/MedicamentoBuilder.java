package com.example.ExercicioSemana6.ex2;

import java.util.Calendar;

public class MedicamentoBuilder {

    private String nome;
    private Integer dosagem;
    private String unidadeDosagem;
    private String nomeLaboratorio;
    private String bula;

    public static MedicamentoBuilder umMedicamento() {
        return new MedicamentoBuilder();
    }

    private MedicamentoBuilder(){
    }

    public MedicamentoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

    public MedicamentoBuilder naDosagem(Integer dosagem) {
        this.dosagem = dosagem;
        return this;
    }

    public MedicamentoBuilder mg() {
        this.unidadeDosagem = "mg";
        return this;
    }

    public MedicamentoBuilder doLaboratorio(String nomeLaboratorio) {
        this.nomeLaboratorio = nomeLaboratorio;
        return this;
    }

    public MedicamentoBuilder comBula(String bula) {
        this.bula = bula;
        return this;
    }

    public Medicamento build() {
        Medicamento medicamento = new Medicamento();

        medicamento.setNome(nome);
        medicamento.setDosagem(dosagem);
        medicamento.setUnidadeDosagem(unidadeDosagem);
        medicamento.setNomeLaboratorio(nomeLaboratorio);
        medicamento.setBula(bula);
        return medicamento;
    }
}
