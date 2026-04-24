package br.dev.guisleri.treinoapispring.dto;

import br.dev.guisleri.treinoapispring.model.DiasSemana;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record TreinoRequestDTO(
        @NotBlank
        String nome,
        Long alunoId,
        @NotEmpty
        List<DiasSemana> diasSemana
) {
}
