package br.dev.guisleri.treinoapispring.exception;

public class TreinoNotFoundException extends RuntimeException {
    public TreinoNotFoundException(String message) {
        super(message);
    }
}
