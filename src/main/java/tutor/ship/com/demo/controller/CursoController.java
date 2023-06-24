package tutor.ship.com.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tutor.ship.com.demo.controller.dto.CursosDTO;
import tutor.ship.com.demo.model.Cursos;
import tutor.ship.com.demo.repository.CursosRepository;
import tutor.ship.com.demo.repository.PersonaRepository;

import java.nio.file.Path;

@RestController
@RequestMapping(path="/api/cursos")
public class CursoController {
    @Autowired
    private CursosRepository cursosRepository;
    @GetMapping
    Page<Cursos> index(@PageableDefault(sort ="denominacion", size = 5)Pageable pageable){
        return cursosRepository.findAll(pageable);
    }
    @GetMapping("/{id}")
    Cursos obtener(@PathVariable Integer id){
        return cursosRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
@ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Cursos crear(@RequestBody @Validated CursosDTO cursosDTO){
        Cursos cursos=new ModelMapper().map(cursosDTO, Cursos.class);
        return cursosRepository.save(cursos);
}
@PutMapping("/{id}")
    Cursos Actualixar(@PathVariable Integer id,@RequestBody CursosDTO cursosDTO){
        Cursos cursos=cursosRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(cursosDTO,cursos);
        return cursosRepository.save(cursos);
}
@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void Eliminar(@PathVariable Integer id){
            Cursos cursos=cursosRepository
                    .findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            cursosRepository.delete(cursos);
}
}
