package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.model.Aluno;
import br.dev.guisleri.treinoapispring.model.Treino;
import br.dev.guisleri.treinoapispring.repo.AlunoRepo;
import br.dev.guisleri.treinoapispring.repo.TreinoRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TreinoService implements ITreinoService {

    private final TreinoRepo treinoRepo;
    private final AlunoRepo alunoRepo;

    @Override
    public Treino save(Treino treino) {
        return treinoRepo.save(treino);
    }

    @Override
    public Treino findById(Long id) {
        return treinoRepo.findById(id).orElseThrow(() -> new RuntimeException("Treino not found! | ID: " + id));
    }

    @Override
    public Treino update(Long id, Long AlunoId, Treino treino) {
        Treino treinoExistente = treinoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino not found! | ID: " + id));

        treinoExistente.setNome(treino.getNome());

        Aluno alunoExistente = alunoRepo.findById(AlunoId)
                .orElseThrow(() -> new RuntimeException("Aluno not found! | ID: " + AlunoId));

        treinoExistente.setAluno(alunoExistente);

        treinoExistente.setDiasSemana(treino.getDiasSemana());

        return treinoRepo.save(treinoExistente);
    }

    @Override
    public List<Treino> findAll() {
        return treinoRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        treinoRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        treinoRepo.deleteAll();
    }
}
