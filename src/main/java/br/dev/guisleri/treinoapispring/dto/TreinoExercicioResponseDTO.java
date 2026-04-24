package br.dev.guisleri.treinoapispring.dto;

public record TreinoExercicioResponseDTO(
        Long id,
        TreinoResponseDTO treino,
        ExercicioResponseDTO exercicio,
        Integer series,
        Integer repeticoes,
        Integer ordem
) {
}
