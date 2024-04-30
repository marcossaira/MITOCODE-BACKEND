package portfolio.miticode_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime fechaMatricula;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "id_estudiante",
            foreignKey = @ForeignKey(name = "FK_MATRICULA_ESTUDIANTE"))
    private Estudiante estudiante;

    @OneToMany(
            mappedBy = "matricula",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<DetalleMatricula> detallesMatricula;
}
