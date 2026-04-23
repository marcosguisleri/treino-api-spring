package br.dev.guisleri.treinoapispring.repo;

import br.dev.guisleri.treinoapispring.model.Aluno;
import org.springframework.data.repository.ListCrudRepository;

public interface AlunoRepo extends ListCrudRepository<Aluno, Long> {
}
