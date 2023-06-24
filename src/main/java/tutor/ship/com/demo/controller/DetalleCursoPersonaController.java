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
import tutor.ship.com.demo.controller.dto.CronogramaCursoDTO;
import tutor.ship.com.demo.controller.dto.DetalleCursoPersonaDTO;
import tutor.ship.com.demo.model.CronogramaCurso;
import tutor.ship.com.demo.model.DetalleCursoPersona;
import tutor.ship.com.demo.repository.DetalleCursoPersonaRepository;

@RestController
@RequestMapping("api/detalleCursoPersona")
public class DetalleCursoPersonaController {
    @Autowired
    private  DetalleCursoPersonaRepository detalleCursoPersonaRepository;

    @GetMapping("")
    Page<DetalleCursoPersona> index(@PageableDefault(sort = "id", size = 5) Pageable pageable){
        return detalleCursoPersonaRepository.findAll(pageable);
    }

    @GetMapping("/{id}")
    DetalleCursoPersona obtener(@PathVariable Integer id){
        return detalleCursoPersonaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/store")
    DetalleCursoPersona store(@RequestBody @Validated DetalleCursoPersonaDTO detalleCursoPersonaDTO){
        DetalleCursoPersona detalleCursoPersona = new ModelMapper().map(detalleCursoPersonaDTO, DetalleCursoPersona.class);
        return detalleCursoPersonaRepository.save(detalleCursoPersona);
    }

    @PutMapping("/{id}")
    DetalleCursoPersona update(@PathVariable Integer id, @RequestBody DetalleCursoPersonaDTO detalleCursoPersonaDTO){
        DetalleCursoPersona detalleCursoPersona = detalleCursoPersonaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        new ModelMapper().map(detalleCursoPersonaDTO, detalleCursoPersona);
        return detalleCursoPersonaRepository.save(detalleCursoPersona);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void destroy(@PathVariable Integer id){
        DetalleCursoPersona detalleCursoPersona = detalleCursoPersonaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        detalleCursoPersonaRepository.delete(detalleCursoPersona);
    }

}
