package br.dev.guisleri.treinoapispring.dto;

import jakarta.validation.constraints.NotNull;

public record TreinoExercicioRequestDTO(
        @NotNull
        Long treinoId,
        @NotNull
        Long exercicioId,
        @NotNull
        Integer series,
        @NotNull
        Integer repeticoes,
        Integer ordem
) {
}
