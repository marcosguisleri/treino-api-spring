package br.dev.guisleri.treinoapispring.repo;

import br.dev.guisleri.treinoapispring.model.Exercicio;
import org.springframework.data.repository.ListCrudRepository;

public interface ExercicioRepo extends ListCrudRepository<Exercicio, Long> {
}
