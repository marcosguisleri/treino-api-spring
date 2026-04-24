package br.dev.guisleri.treinoapispring.exception;

public class ExercicioNaoEncontrado extends RuntimeException {
    public ExercicioNaoEncontrado(String message) {
        super(message);
    }
}
