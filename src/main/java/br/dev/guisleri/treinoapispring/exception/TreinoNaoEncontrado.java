package br.dev.guisleri.treinoapispring.exception;

public class TreinoNaoEncontrado extends RuntimeException {
    public TreinoNaoEncontrado(String message) {
        super(message);
    }
}
