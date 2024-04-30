package portfolio.miticode_backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record EstudianteDTO(
        Integer id,
        @NotNull(message = "El nombre no puede ser nulo")
        String nombres,
        @NotNull(message = "Los apellidos no pueden ser nulos")
        String apellidos,
        @NotNull(message = "El DNI no puede ser nulo")
        @Pattern(regexp = "^[0-9]{8}$", message = "El DNI es inválido")
        String dni,
        int edad
) {
}
