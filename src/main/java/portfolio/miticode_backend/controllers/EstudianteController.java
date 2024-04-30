package portfolio.miticode_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import portfolio.miticode_backend.dto.EstudianteDTO;
import portfolio.miticode_backend.dto.EstudianteUpdateDTO;
import portfolio.miticode_backend.mappers.EstudianteMapper;
import portfolio.miticode_backend.models.Estudiante;
import portfolio.miticode_backend.services.IEstudianteService;

import java.net.URI;
import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
    private final IEstudianteService estudianteService;
    private final EstudianteMapper estudianteMapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid EstudianteDTO estudianteDTO) {
        estudianteService.validateDniExistence(estudianteDTO.dni());
        Integer id = estudianteService.save(estudianteMapper.convertToEntity(estudianteDTO)).getId();
        URI location = URI.create(String.format("/estudiantes/%s", id));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> findAll() {
        List<EstudianteDTO> estudiantes = estudianteService.findAll()
                .stream()
                .map(estudianteMapper::convertToDTO)
                .sorted(Comparator.comparing(EstudianteDTO::edad).reversed()).toList();
        return ResponseEntity.ok(estudiantes);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody @Valid EstudianteUpdateDTO estudianteUpdateDTO) {
        Estudiante estudiante = estudianteService.findById(id);
        estudianteMapper.updateEntityFromDTO(estudianteUpdateDTO, estudiante);
        estudianteService.save(estudiante);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        estudianteService.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
