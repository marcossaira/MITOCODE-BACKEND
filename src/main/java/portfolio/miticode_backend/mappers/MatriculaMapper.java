package portfolio.miticode_backend.mappers;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import portfolio.miticode_backend.dto.MatriculaDTO;
import portfolio.miticode_backend.models.Matricula;

@Mapper(componentModel = "spring",
        uses = {EstudianteMapper.class, DetalleMatriculaMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class MatriculaMapper {
    public abstract Matricula convertToEntity(MatriculaDTO matriculaDTO, @Context CycleAvoidingMappingContext context);
    public abstract MatriculaDTO convertToDTO(Matricula matricula, @Context CycleAvoidingMappingContext context);
}
