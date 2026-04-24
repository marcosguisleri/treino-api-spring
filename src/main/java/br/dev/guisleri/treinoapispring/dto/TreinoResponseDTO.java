package br.dev.guisleri.treinoapispring.dto;

import br.dev.guisleri.treinoapispring.model.DiasSemana;

import java.util.List;

public record TreinoResponseDTO(
        Long id,
        String nome,
        AlunoResponseDTO aluno,
        List<DiasSemana> diasSemana
) {
}
