package portfolio.miticode_backend.mappers;

import org.mapstruct.*;
import portfolio.miticode_backend.dto.CursoDTO;
import portfolio.miticode_backend.dto.CursoUpdateDTO;
import portfolio.miticode_backend.models.Curso;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CursoMapper {
    public abstract Curso convertToEntity(CursoDTO cursoDTO);

    public abstract CursoDTO convertToDTO(Curso curso);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public abstract void updateEntityFromDTO(CursoUpdateDTO cursoUpdateDTO, @MappingTarget Curso curso);
}
