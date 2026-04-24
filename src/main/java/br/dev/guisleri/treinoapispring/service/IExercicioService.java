package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.model.Exercicio;

import java.util.List;

public interface IExercicioService {
    Exercicio save(Exercicio exercicio);
    Exercicio findById(Long id);
    Exercicio update(Long id, Exercicio exercicio);
    List<Exercicio> findAll();
    void delete(Long id);
    void deleteAll();
}
