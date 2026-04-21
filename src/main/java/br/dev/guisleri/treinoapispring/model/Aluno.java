package br.dev.guisleri.treinoapispring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "dta_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "dta_matricula")
    private LocalDate dataMatricula;

    @Column(name = "status")
    private boolean ativo;

}
