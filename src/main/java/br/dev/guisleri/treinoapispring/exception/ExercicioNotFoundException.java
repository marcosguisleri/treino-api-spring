package br.dev.guisleri.treinoapispring.exception;

public class ExercicioNotFoundException extends RuntimeException {
    public ExercicioNotFoundException(String message) {
        super(message);
    }
}
