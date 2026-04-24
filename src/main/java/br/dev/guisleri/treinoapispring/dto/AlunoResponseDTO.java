package br.dev.guisleri.treinoapispring.dto;

import java.time.LocalDate;

public record AlunoResponseDTO(
        Long id,
        String nome,
        LocalDate dataNascimento,
        LocalDate dataMatricula,
        boolean ativo
) {
}
