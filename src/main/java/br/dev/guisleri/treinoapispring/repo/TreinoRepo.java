package br.dev.guisleri.treinoapispring.repo;

import br.dev.guisleri.treinoapispring.model.Treino;
import org.springframework.data.repository.ListCrudRepository;

public interface TreinoRepo extends ListCrudRepository<Treino, Long> {
}
