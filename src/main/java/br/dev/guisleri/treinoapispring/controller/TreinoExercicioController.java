package br.dev.guisleri.treinoapispring.controller;

import br.dev.guisleri.treinoapispring.dto.*;
import br.dev.guisleri.treinoapispring.model.TreinoExercicio;
import br.dev.guisleri.treinoapispring.service.TreinoExercicioService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treino-exercicios")
@RequiredArgsConstructor
public class TreinoExercicioController {

    private final TreinoExercicioService treinoExercicioService;

    @GetMapping
    public ResponseEntity<List<TreinoExercicioResponseDTO>> listAllTreinoExercicio() {
        List<TreinoExercicioResponseDTO> list = treinoExercicioService.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok((list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoExercicioResponseDTO> findById(@PathVariable Long id) {
        TreinoExercicio treinoExercicio = treinoExercicioService.findById(id);
        return ResponseEntity.ok(toDTO(treinoExercicio));
    }

    @PostMapping
    public ResponseEntity<TreinoExercicioResponseDTO> createTreinoExercicio(
            @Valid @RequestBody TreinoExercicioRequestDTO dto) {

        TreinoExercicio treinoExercicio = treinoExercicioService.save(dto);

        return ResponseEntity
                .status(201)
                .body(toDTO(treinoExercicio));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoExercicioResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody TreinoExercicioRequestDTO dto) {

        TreinoExercicio atualizado = treinoExercicioService.update(id, dto);

        return ResponseEntity.ok(toDTO(atualizado));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTreinoExercicios() {
        treinoExercicioService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        treinoExercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private TreinoExercicioResponseDTO toDTO(TreinoExercicio treinoExercicio) {
        AlunoResponseDTO alunoDTO = new AlunoResponseDTO(
                treinoExercicio.getTreino().getAluno().getId(),
                treinoExercicio.getTreino().getAluno().getNome(),
                treinoExercicio.getTreino().getAluno().getDataNascimento(),
                treinoExercicio.getTreino().getAluno().getDataMatricula(),
                treinoExercicio.getTreino().getAluno().isAtivo()
        );

        TreinoResponseDTO treinoDTO = new TreinoResponseDTO(
                treinoExercicio.getTreino().getId(),
                treinoExercicio.getTreino().getNome(),
                alunoDTO,
                treinoExercicio.getTreino().getDiasSemana()
        );

        ExercicioResponseDTO exercicioDTO = new ExercicioResponseDTO(
                treinoExercicio.getExercicio().getId(),
                treinoExercicio.getExercicio().getNome(),
                treinoExercicio.getExercicio().getGrupoMuscular()
        );

        return new TreinoExercicioResponseDTO(
                treinoExercicio.getId(),
                treinoDTO,
                exercicioDTO,
                treinoExercicio.getSeries(),
                treinoExercicio.getRepeticoes(),
                treinoExercicio.getOrdem()
        );
    }

}
