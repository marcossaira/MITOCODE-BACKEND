package portfolio.miticode_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record CursoDTO(
        Integer id,
        @NotNull
        String nombre,
        @NotNull
        String siglas,
        boolean estado
) {
}
