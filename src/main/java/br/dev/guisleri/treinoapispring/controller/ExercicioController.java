package br.dev.guisleri.treinoapispring.controller;

import br.dev.guisleri.treinoapispring.dto.ExercicioRequestDTO;
import br.dev.guisleri.treinoapispring.dto.ExercicioResponseDTO;
import br.dev.guisleri.treinoapispring.model.Exercicio;
import br.dev.guisleri.treinoapispring.service.ExercicioService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
public class ExercicioController {

    private final ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<ExercicioResponseDTO>> listAllExercicios() {
        List<ExercicioResponseDTO> list = exercicioService.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> findById(@PathVariable Long id) {
        Exercicio exercicio = exercicioService.findById(id);
        return ResponseEntity.ok(toDTO(exercicio));
    }

    @PostMapping
    public ResponseEntity<ExercicioResponseDTO> createExercicio(@Valid @RequestBody ExercicioRequestDTO dto) {
        Exercicio exercicio = toEntity(dto);
        return ResponseEntity.status(201).body(toDTO(exercicioService.save(exercicio)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExercicioResponseDTO> updateExercicio(@PathVariable Long id, @Valid @RequestBody ExercicioRequestDTO dto) {
        Exercicio exercicio = toEntity(dto);
        return ResponseEntity.ok(toDTO(exercicioService.update(id, exercicio)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllExercicios() {
        exercicioService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        exercicioService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ExercicioResponseDTO toDTO(Exercicio exercicio) {
        return new ExercicioResponseDTO(
                exercicio.getId(),
                exercicio.getNome(),
                exercicio.getGrupoMuscular()
        );
    }

    private Exercicio toEntity(ExercicioRequestDTO dto) {
        Exercicio exercicio = new Exercicio();
        exercicio.setNome(dto.nome());
        exercicio.setGrupoMuscular(dto.grupoMuscular());
        return exercicio;
    }
}
