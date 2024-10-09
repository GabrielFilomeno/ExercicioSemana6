package com.example.ExercicioSemana6.ex4.exceptions;

public class ParametroInvalidoException extends RuntimeException {
    private final String campo;

    public ParametroInvalidoException(String campo, String mensagem) {
        super(String.format("Campo %s é invalido %s", campo, mensagem));
        this.campo = campo;
    }
}
