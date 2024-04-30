package portfolio.miticode_backend.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private int edad;

    @OneToMany(
            mappedBy = "estudiante",
            cascade = {CascadeType.ALL},
            orphanRemoval = true)
    private List<Matricula> matricula;
}
