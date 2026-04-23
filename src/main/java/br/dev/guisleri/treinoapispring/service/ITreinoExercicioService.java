package br.dev.guisleri.treinoapispring.service;

import java.util.List;

public interface ITreinoExercicioService {
    ITreinoExercicioService save(ITreinoExercicioService ITreinoExercicioService);
    ITreinoExercicioService findById(Long id);
    ITreinoExercicioService update(Long id, ITreinoExercicioService ITreinoExercicioService);
    List<ITreinoExercicioService> findAll();
    void delete(Long id);
    void deleteAll();
}
