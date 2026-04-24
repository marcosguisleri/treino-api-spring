package br.dev.guisleri.treinoapispring.exception;

public class AlunoNaoEncontrado extends RuntimeException {
    public AlunoNaoEncontrado(String message) {
        super(message);
    }
}
