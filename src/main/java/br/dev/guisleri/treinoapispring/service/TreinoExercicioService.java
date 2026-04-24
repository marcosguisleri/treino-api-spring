package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.dto.TreinoExercicioRequestDTO;
import br.dev.guisleri.treinoapispring.exception.TreinoExercicioNotFoundException;
import br.dev.guisleri.treinoapispring.model.Exercicio;
import br.dev.guisleri.treinoapispring.model.Treino;
import br.dev.guisleri.treinoapispring.model.TreinoExercicio;
import br.dev.guisleri.treinoapispring.repo.TreinoExercicioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoExercicioService implements ITreinoExercicioService {

    private final TreinoExercicioRepo treinoExercicioRepo;
    private final TreinoService treinoService;
    private final ExercicioService exercicioService;

    @Override
    public TreinoExercicio save(TreinoExercicioRequestDTO dto) {
        Treino treino = treinoService.findById(dto.treinoId());
        Exercicio exercicio = exercicioService.findById(dto.exercicioId());

        TreinoExercicio te = new TreinoExercicio();
        te.setTreino(treino);
        te.setExercicio(exercicio);
        te.setSeries(dto.series());
        te.setRepeticoes(dto.repeticoes());
        te.setOrdem(dto.ordem());

        return treinoExercicioRepo.save(te);
    }

    @Override
    public TreinoExercicio findById(Long id) {
        return treinoExercicioRepo.findById(id)
                .orElseThrow(() -> new TreinoExercicioNotFoundException("TreinoExercicio not found! | ID: " + id));
    }

    @Override
    public TreinoExercicio update(Long id, TreinoExercicioRequestDTO dto) {
        TreinoExercicio te = findById(id);

        te.setSeries(dto.series());
        te.setRepeticoes(dto.repeticoes());
        te.setOrdem(dto.ordem());

        return treinoExercicioRepo.save(te);
    }

    @Override
    public List<TreinoExercicio> findAll() {
        return treinoExercicioRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        treinoExercicioRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        treinoExercicioRepo.deleteAll();
    }
}
