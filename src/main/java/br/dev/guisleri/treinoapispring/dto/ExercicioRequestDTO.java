package br.dev.guisleri.treinoapispring.dto;

import br.dev.guisleri.treinoapispring.model.GrupoMuscular;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ExercicioRequestDTO(
        @NotBlank
        String nome,
        @NotNull
        GrupoMuscular grupoMuscular
) {
}
