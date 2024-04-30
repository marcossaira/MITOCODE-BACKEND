package portfolio.miticode_backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDTO {
        @NotNull(message = "El curso no puede ser nulo")
        CursoDTO curso;
        @NotNull(message = "El aula no puede ser nula")
        String aula;
        @JsonBackReference
        MatriculaDTO matricula;
}
