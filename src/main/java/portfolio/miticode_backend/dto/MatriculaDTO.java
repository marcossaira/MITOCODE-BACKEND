package portfolio.miticode_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {
    Integer id;

    @NotNull
    EstudianteDTO estudiante;

    LocalDateTime fechaMatricula = LocalDateTime.now();

    @JsonManagedReference
    @NotNull
    List<DetalleMatriculaDTO> detallesMatricula;
}
