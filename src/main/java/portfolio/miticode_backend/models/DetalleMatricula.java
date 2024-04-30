package portfolio.miticode_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "id_curso",
            foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA_CURSO"))
    private Curso curso;

    @Column(nullable = false)
    private String aula;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "id_matricula",
            foreignKey = @ForeignKey(name = "FK_DETALLE_MATRICULA_MATRICULA")
    )
    private Matricula matricula;
}
