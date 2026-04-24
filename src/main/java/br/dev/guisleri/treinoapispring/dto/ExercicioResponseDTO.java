package br.dev.guisleri.treinoapispring.dto;

import br.dev.guisleri.treinoapispring.model.GrupoMuscular;

public record ExercicioResponseDTO(
        Long id,
        String nome,
        GrupoMuscular grupoMuscular
) {
}
