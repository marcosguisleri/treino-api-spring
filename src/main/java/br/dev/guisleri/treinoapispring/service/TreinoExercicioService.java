package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.exception.TreinoExercicioNaoEncontrado;
import br.dev.guisleri.treinoapispring.model.Exercicio;
import br.dev.guisleri.treinoapispring.model.Treino;
import br.dev.guisleri.treinoapispring.model.TreinoExercicio;
import br.dev.guisleri.treinoapispring.repo.TreinoExercicioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoExercicioService implements ITreinoExercicio{

    private final TreinoExercicioRepo treinoExercicioRepo;
    private final TreinoService treinoService;
    private final ExercicioService exercicioService;

    @Override
    public TreinoExercicio save(Long treinoId, Long exercicioId, Integer series, Integer repeticoes, Integer ordem) {
        Treino treino = treinoService.findById(treinoId);
        Exercicio exercicio = exercicioService.findById(exercicioId);

        TreinoExercicio treinoExercicio = new TreinoExercicio();
        treinoExercicio.setTreino(treino);
        treinoExercicio.setExercicio(exercicio);
        treinoExercicio.setSeries(series);
        treinoExercicio.setRepeticoes(repeticoes);
        treinoExercicio.setOrdem(ordem);

        return treinoExercicioRepo.save(treinoExercicio);
    }

    @Override
    public TreinoExercicio findById(Long id) {
        return treinoExercicioRepo.findById(id)
                .orElseThrow(() -> new TreinoExercicioNaoEncontrado("TreinoExercicio not found! | ID: " + id));
    }

    @Override
    public TreinoExercicio update(Long id, Integer series, Integer repeticoes, Integer ordem) {
        return null;
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
