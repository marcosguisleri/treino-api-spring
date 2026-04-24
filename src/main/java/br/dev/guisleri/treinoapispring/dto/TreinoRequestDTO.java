package br.dev.guisleri.treinoapispring.dto;

import br.dev.guisleri.treinoapispring.model.DiasSemana;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record TreinoRequestDTO(
        @NotBlank
        String nome,
        @NotBlank
        Long alunoId,
        @NotBlank
        List<DiasSemana> diasSemana
) {
}
