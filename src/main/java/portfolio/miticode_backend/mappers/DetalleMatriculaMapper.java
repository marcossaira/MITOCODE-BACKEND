package portfolio.miticode_backend.mappers;

import org.mapstruct.*;
import portfolio.miticode_backend.dto.DetalleMatriculaDTO;
import portfolio.miticode_backend.models.DetalleMatricula;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CursoMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DetalleMatriculaMapper {
    public abstract DetalleMatricula convertToEntity(DetalleMatriculaDTO detalleMatriculaDTO, @Context CycleAvoidingMappingContext context);
    public abstract DetalleMatriculaDTO convertToDTO(DetalleMatricula detalleMatricula, @Context CycleAvoidingMappingContext context);
}
