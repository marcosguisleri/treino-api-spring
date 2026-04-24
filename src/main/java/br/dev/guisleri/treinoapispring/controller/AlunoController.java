package br.dev.guisleri.treinoapispring.controller;

import br.dev.guisleri.treinoapispring.dto.AlunoRequestDTO;
import br.dev.guisleri.treinoapispring.dto.AlunoResponseDTO;
import br.dev.guisleri.treinoapispring.model.Aluno;
import br.dev.guisleri.treinoapispring.service.AlunoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listAllAlunos() {
        List<AlunoResponseDTO> list = alunoService.findAll()
                .stream()
                .map(this::toDTO)
                .toList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> findById(@PathVariable Long id) {
        Aluno aluno = alunoService.findById(id);
        return ResponseEntity.ok(toDTO(aluno));
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> createAluno(@Valid @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = toEntity(dto);
        return ResponseEntity.status(201).body(toDTO(alunoService.save(aluno)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> updateAluno(@PathVariable Long id, @Valid @RequestBody AlunoRequestDTO dto) {
        Aluno aluno = toEntity(dto);
        return ResponseEntity.ok(toDTO(alunoService.update(id, aluno)));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllAlunos() {
        alunoService.deleteAll();
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        alunoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private AlunoResponseDTO toDTO(Aluno aluno) {
        return new AlunoResponseDTO(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getDataMatricula(),
                aluno.isAtivo()
        );
    }

    private Aluno toEntity(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.nome());
        aluno.setDataNascimento(dto.dataNascimento());

        return aluno;
    }

}