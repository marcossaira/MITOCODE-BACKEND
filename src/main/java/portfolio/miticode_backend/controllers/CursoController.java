package portfolio.miticode_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import portfolio.miticode_backend.dto.CursoDTO;
import portfolio.miticode_backend.dto.CursoUpdateDTO;
import portfolio.miticode_backend.mappers.CursoMapper;
import portfolio.miticode_backend.models.Curso;
import portfolio.miticode_backend.services.ICursoService;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final ICursoService cursoService;
    private final CursoMapper cursoMapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid CursoDTO cursoDTO) {
        cursoService.validateNameExistence(cursoDTO.nombre());
        Integer id = cursoService.save(cursoMapper.convertToEntity(cursoDTO)).getId();
        URI location = URI.create(String.format("/cursos/%s", id));
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> findAll() {
        List<CursoDTO> cursos = cursoService.findAll().stream().map(cursoMapper::convertToDTO).toList();
        return ResponseEntity.ok(cursos);
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody @Valid CursoUpdateDTO cursoUpdateDTO) {
        Curso curso = cursoService.findById(id);
        cursoMapper.updateEntityFromDTO(cursoUpdateDTO, curso);
        cursoService.save(curso);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
