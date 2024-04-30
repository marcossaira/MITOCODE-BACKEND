package portfolio.miticode_backend.dto;

import jakarta.validation.constraints.Pattern;

public record EstudianteUpdateDTO(
        String nombres,
        String apellidos,
        @Pattern(regexp = "^[0-9]{8}$", message = "El DNI es inválido")
        String dni,
        Integer edad
) {
}
