package br.dev.guisleri.treinoapispring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_treinos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tb_treino_dias",
            joinColumns = @JoinColumn(name = "treino_id")
    )
    @Column(name = "dias_semana", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<DiasSemana> diasSemana;

}
