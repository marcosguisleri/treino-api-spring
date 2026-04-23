package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.model.Treino;

import java.util.List;

public interface ITreinoService {
    Treino save(Treino treino);
    Treino findById(Long id);
    Treino update(Long id, Long AlunoId, Treino treino);
    List<Treino> findAll();
    void delete(Long id);
    void deleteAll();
}
