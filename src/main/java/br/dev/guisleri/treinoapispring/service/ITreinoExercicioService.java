package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.dto.TreinoExercicioRequestDTO;
import br.dev.guisleri.treinoapispring.dto.TreinoRequestDTO;
import br.dev.guisleri.treinoapispring.model.TreinoExercicio;

import java.util.List;

public interface ITreinoExercicioService {
    TreinoExercicio save(TreinoExercicioRequestDTO dto);

    TreinoExercicio findById(Long id);

    TreinoExercicio update(Long id, TreinoExercicioRequestDTO dto);

    List<TreinoExercicio> findAll();

    void delete(Long id);

    void deleteAll();
}
