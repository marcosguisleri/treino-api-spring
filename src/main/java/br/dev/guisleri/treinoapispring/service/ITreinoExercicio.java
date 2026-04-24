package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.model.TreinoExercicio;

import java.util.List;

public interface ITreinoExercicio {
    TreinoExercicio save(Long treinoId, Long exercicioId, Integer series, Integer repeticoes, Integer ordem);

    TreinoExercicio findById(Long id);

    TreinoExercicio update(Long id, Integer series, Integer repeticoes, Integer ordem);

    List<TreinoExercicio> findAll();

    void delete(Long id);

    void deleteAll();
}
