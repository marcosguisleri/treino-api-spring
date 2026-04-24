package br.dev.guisleri.treinoapispring.controller;

import br.dev.guisleri.treinoapispring.dto.AlunoResponseDTO;
import br.dev.guisleri.treinoapispring.dto.TreinoRequestDTO;
import br.dev.guisleri.treinoapispring.dto.TreinoResponseDTO;
import br.dev.guisleri.treinoapispring.model.Aluno;
import br.dev.guisleri.treinoapispring.model.Treino;
import br.dev.guisleri.treinoapispring.service.AlunoService;
import br.dev.guisleri.treinoapispring.service.TreinoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
@RequiredArgsConstructor
public class TreinoController {

    private final TreinoService treinoService;
    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<TreinoResponseDTO>> listAllTreinos() {
        List<TreinoResponseDTO> list = treinoService.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> findById(@PathVariable Long id) {
        Treino treino = treinoService.findById(id);
        return ResponseEntity.ok(toDTO(treino));
    }

    @PostMapping
    public ResponseEntity<TreinoResponseDTO> createTreino(@Valid @RequestBody TreinoRequestDTO dto) {
        Treino treino = toEntity(dto);
        return ResponseEntity.status(201).body(toDTO(treinoService.save(treino)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> updateTreino(@PathVariable Long id, @Valid @RequestBody TreinoRequestDTO dto) {
        Treino treino = toEntity(dto);
        return ResponseEntity.ok(toDTO(treinoService.update(id, dto.alunoId(), treino)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllTreinos() {
        treinoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        treinoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private TreinoResponseDTO toDTO(Treino treino) {
        AlunoResponseDTO alunoDTO = new AlunoResponseDTO(
                treino.getAluno().getId(),
                treino.getAluno().getNome(),
                treino.getAluno().getDataNascimento(),
                treino.getAluno().getDataMatricula(),
                treino.getAluno().isAtivo()
        );

        return new TreinoResponseDTO(
                treino.getId(),
                treino.getNome(),
                alunoDTO,
                treino.getDiasSemana()
        );
    }

    private Treino toEntity(TreinoRequestDTO dto) {
        Aluno aluno = alunoService.findById(dto.alunoId());

        Treino treino = new Treino();
        treino.setNome(dto.nome());
        treino.setAluno(aluno);
        treino.setDiasSemana(dto.diasSemana());

        return treino;
    }

}
