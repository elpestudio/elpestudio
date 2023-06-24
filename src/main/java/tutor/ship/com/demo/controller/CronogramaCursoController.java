package tutor.ship.com.demo.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tutor.ship.com.demo.controller.dto.CronogramaCursoDTO;
import tutor.ship.com.demo.model.CronogramaCurso;
import tutor.ship.com.demo.model.Cursos;
import tutor.ship.com.demo.repository.CronogramaCursoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestBody;
import tutor.ship.com.demo.repository.CursosRepository;
import tutor.ship.com.demo.repository.PersonaRepository;

import java.util.Optional;

@RestController
@RequestMapping("api/cronogramaCurso")
public class CronogramaCursoController {

    @Autowired
    private CronogramaCursoRepository cronogramaCursoRepository;

    @GetMapping("")
    Page <CronogramaCurso> index(@PageableDefault(sort = "id", size = 5) Pageable pageable){
        return cronogramaCursoRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    CronogramaCurso obtener(@PathVariable Integer id){
        return cronogramaCursoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/store")
    CronogramaCurso store(@RequestBody @Validated CronogramaCursoDTO cronogramaCursoDTO){
        CronogramaCurso cronogramaCurso = new ModelMapper().map(cronogramaCursoDTO, CronogramaCurso.class);
        return cronogramaCursoRepository.save(cronogramaCurso);
    }

    @PutMapping("/{id}")
    CronogramaCurso update(@PathVariable Integer id, @RequestBody CronogramaCursoDTO cronogramaCursoDTO){
        CronogramaCurso cronogramaCurso = cronogramaCursoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(cronogramaCursoDTO, cronogramaCurso);
        return cronogramaCursoRepository.save(cronogramaCurso);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void destroy(@PathVariable Integer id){
        CronogramaCurso cronogramaCurso = cronogramaCursoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        cronogramaCursoRepository.delete(cronogramaCurso);
    }
}
