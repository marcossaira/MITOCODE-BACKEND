package portfolio.miticode_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import portfolio.miticode_backend.dto.MatriculaDTO;
import portfolio.miticode_backend.mappers.CycleAvoidingMappingContext;
import portfolio.miticode_backend.mappers.MatriculaMapper;
import portfolio.miticode_backend.models.DetalleMatricula;
import portfolio.miticode_backend.models.Matricula;
import portfolio.miticode_backend.services.IMatriculaService;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/matricula")
public class MatriculaController {

    private final IMatriculaService matriculaService;
    private final MatriculaMapper matriculaMapper;

    @Transactional
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid MatriculaDTO matriculaDTO) {
        Integer id = matriculaService.save(matriculaMapper.convertToEntity(matriculaDTO, new CycleAvoidingMappingContext())).getId();
        URI location = URI.create(String.format("/matricula/%d", id));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<Map<String, List<String>>> getMatriculas() {
        Map<String, List<String>> matriculas = matriculaService.findAll()
                .stream()
                .flatMap(matricula -> matricula.getDetallesMatricula().stream())
                .collect(Collectors.groupingBy(detalleMatricula -> detalleMatricula.getCurso().getNombre(),
                        Collectors.mapping(detalleMatricula -> {
                            StringBuilder estudiante = new StringBuilder();
                            estudiante.append(detalleMatricula.getMatricula().getEstudiante().getNombres());
                            estudiante.append(" ");
                            estudiante.append(detalleMatricula.getMatricula().getEstudiante().getApellidos());
                            return estudiante.toString();
                        }, Collectors.toList())));
        return ResponseEntity.ok(matriculas);
    }

}
