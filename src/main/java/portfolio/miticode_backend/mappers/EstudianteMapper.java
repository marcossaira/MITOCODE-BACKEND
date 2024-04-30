package portfolio.miticode_backend.mappers;

import org.mapstruct.*;
import portfolio.miticode_backend.dto.EstudianteDTO;
import portfolio.miticode_backend.dto.EstudianteUpdateDTO;
import portfolio.miticode_backend.models.Estudiante;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class EstudianteMapper {
    public abstract Estudiante convertToEntity(EstudianteDTO estudianteDTO);

    public abstract EstudianteDTO convertToDTO(Estudiante estudiante);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntityFromDTO(EstudianteUpdateDTO estudianteUpdateDTO, @MappingTarget Estudiante estudiante);
}
