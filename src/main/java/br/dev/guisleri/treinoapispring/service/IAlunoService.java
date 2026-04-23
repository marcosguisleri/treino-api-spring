package br.dev.guisleri.treinoapispring.service;

import br.dev.guisleri.treinoapispring.model.Aluno;

import java.util.List;

public interface IAlunoService {
    Aluno save(Aluno aluno);
    Aluno findById(Long id);
    Aluno update(Long id, Aluno aluno);
    List<Aluno> findAll();
    void delete(Long id);
    void deleteAll();
}
