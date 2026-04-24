package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.exception.AlunoNaoEncontrado;
import br.dev.guisleri.treinoapispring.model.Aluno;
import br.dev.guisleri.treinoapispring.repo.AlunoRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService implements IAlunoService {

    private final AlunoRepo alunoRepo;

    @Override
    public Aluno save(Aluno aluno) {
        return alunoRepo.save(aluno);
    }

    @Override
    public Aluno findById(Long id) {
        return alunoRepo.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontrado("Aluno not found! | ID: " + id));
    }

    @Override
    public Aluno update(Long id, Aluno aluno) {
        Aluno alunoExistente = alunoRepo.findById(id)
                .orElseThrow(() -> new AlunoNaoEncontrado("Aluno not found! | ID: " + id));

        alunoExistente.setNome(aluno.getNome());
        alunoExistente.setDataNascimento(aluno.getDataNascimento());
        alunoExistente.setDataMatricula(aluno.getDataMatricula());
        alunoExistente.setAtivo(aluno.isAtivo());

        return alunoRepo.save(alunoExistente);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepo.findAll();
    }

    @Override
    public void delete(Long id) {
        alunoRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        alunoRepo.deleteAll();
    }
}
