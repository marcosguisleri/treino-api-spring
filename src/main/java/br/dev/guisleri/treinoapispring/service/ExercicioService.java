package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.exception.ExercicioNaoEncontrado;
import br.dev.guisleri.treinoapispring.model.Exercicio;
import br.dev.guisleri.treinoapispring.repo.ExercicioRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService implements IExercicioService {

    private final ExercicioRepo exercicioRepo;

    @Override
    public Exercicio save(Exercicio exercicio) {
        return exercicioRepo.save(exercicio);
    }

    @Override
    public Exercicio findById(Long id) {
        return exercicioRepo.findById(id).orElseThrow(() -> new ExercicioNaoEncontrado("Exercicio not found! | ID: " + id));
    }

    @Override
    public Exercicio update(Long id, Exercicio exercicio) {
        Exercicio exercicioExistente = exercicioRepo.findById(id)
                .orElseThrow(() -> new ExercicioNaoEncontrado("Exercicio not found! | ID: " + id));

        exercicioExistente.setNome(exercicio.getNome());
        exercicioExistente.setGrupoMuscular(exercicio.getGrupoMuscular());

        return exercicioRepo.save(exercicioExistente);
    }

    @Override
    public List<Exercicio> findAll() {
        return exercicioRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        exercicioRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        exercicioRepo.deleteAll();
    }
}
