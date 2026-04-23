package br.dev.guisleri.treinoapispring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_treino_exercicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreinoExercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "treino_id", nullable = false)
    private Treino treino;

    @ManyToOne
    @JoinColumn(name = "exercicio_id", nullable = false)
    private Exercicio exercicio;

    @Column(name = "series", nullable = false)
    private Integer series;

    @Column(name = "repeticoes", nullable = false)
    private Integer repeticoes;

    @Column(name = "ordem")
    private Integer ordem;

}
